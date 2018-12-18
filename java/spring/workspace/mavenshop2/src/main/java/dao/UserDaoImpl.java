package dao;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import logic.User;

public class UserDaoImpl implements UserDao {
	private NamedParameterJdbcTemplate template;
	public void setDataSource(DataSource dataSource) {
		this.template = new NamedParameterJdbcTemplate(dataSource);
	}
	@Override
	public void insert(User user) {
		// user객체의 프로퍼티를 sql의 파라미터 값으로 설정
		SqlParameterSource param = new BeanPropertySqlParameterSource(user);
		String sql = "insert into userAccount (userid, username, password, birthday, phoneno, postcode, address, email)"
				+ " values (:userId, :userName, :password, :birthDay, :phoneNo, :postcode, :address, :email)";
		template.update(sql, param);
	}
	@Override
	public User select(String userId){
		String sql = "select * from userAccount where userid = :userId";
		RowMapper<User> mapper = new BeanPropertyRowMapper<User>(User.class);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("userId", userId);
		return template.queryForObject(sql, param, mapper);	// 하나의 Object 형태로 전달
	}
}
