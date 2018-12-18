package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import logic.Board;
import logic.User;
@Repository
public class UserDao {
	
	private NamedParameterJdbcTemplate template;
	private RowMapper<User> mapper = new BeanPropertyRowMapper<User>(User.class);
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.template = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public void insertUser(User user) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(user);
		String sql = "insert into useraccount (userid, username, password, birthday, phoneno, postcode, address, email)"
				+ " values (:userId, :userName, :password, :birthDay, :phoneNo, :postcode, :address, :email)";
		template.update(sql, param);//nullpointer exception
	}
	
	public User selectUser(String userId){
		String sql = "select * from useraccount where userid = :userId";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("userId", userId);
		return template.queryForObject(sql, param, mapper);	// 하나의 Object 형태로 전달
	}

	public void update(User user) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(user);
		String sql = "update useraccount set username=:userName,password=:password,birthday=:birthDay,phoneno=:phoneNo,postcode=:postcode,address=:address,email=:email where userid=:userId";
		template.update(sql, param);
		
	}

	public void deleteUser(String userId) {
		String sql = "delete from useraccount where userid=:userId";
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("userId", userId);
		template.update(sql, param);
		
	}

	public List<User> userList() {
		return template.query("select * from useraccount", mapper);
	}
	// idchks : test1, test2
	// ids : 'test1','test2'
	// sql : select * from useraccount where userid in ('test1','test2')
	public List<User> userList(String[] idchks) {
		String ids = "";
		for(int i=0;i<idchks.length;i++) {
			ids += "'"+idchks[i] + ((i==idchks.length-1)? "'":"',");
		}
		String sql = "select * from useraccount where userid in (" + ids+")";
		return template.query(sql, mapper);
	}

}
