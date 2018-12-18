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

@Repository
public class BoardDao {
	
	private NamedParameterJdbcTemplate template;
	private RowMapper<Board> mapper = new BeanPropertyRowMapper<Board>(Board.class);
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.template = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public Board selectBoard(Integer num) {
		String sql = "select num,name,pass,subject,content,file1 fileurl,regdate,readcnt,ref,reflevel,refstep from board where num = :num";
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("num", num);
		return template.queryForObject(sql, param, mapper);
	}

	public int count(String searchType, String searchContent) {
		String sql ="select count(*) from board ";
		if(searchType != null && searchContent!=null) {
			sql += " where "+ searchType + " like"+ "'%"+ searchContent + "%'";
		}
		Integer ret = template.queryForObject(sql, new HashMap(), Integer.class);
		return ret;
	}
	
	public List<Board> list(String searchType, String searchContent, Integer pageNum, int limit) {
		String sql ="select num,name,pass,subject,content,file1 fileurl,regdate,readcnt,ref,reflevel,refstep from board ";
		if(searchType != null && searchContent!=null) {
			sql += " where "+ searchType + " like "+ "'%"+ searchContent + "%'";
		}
		sql += " order by ref desc, refstep asc limit :startrow, :limit";
		Map<String,Integer> param = new HashMap<String,Integer>();
		int startrow = (pageNum-1)*limit;
		param.put("startrow", startrow);
		param.put("limit", limit);

		return template.query(sql,param,mapper);
	}

	public void write(Board board) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(board);
		String sql = "insert into board (num,name,pass,subject,content,file1,regdate,readcnt,ref,reflevel,refstep) "
			     + " values (:num,:name,:pass,:subject,:content,:fileurl,now(),0,:ref,:reflevel,:refstep)";
		template.update(sql, param);
	}

	public int maxNum() {
		String sql = "select ifnull(max(num),0) from board";
		int ret = template.queryForObject(sql, new HashMap(), Integer.class);
		return ret;
	}

	public void readcnt(int num) {
		String sql = "update board set readcnt=readcnt+1 where num=:num";
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("num",num);
		template.update(sql, param);
	}



	public void updateAboutRef(int ref, int refstep) {
		String sql = "update board set refstep=refstep+1 where ref=:ref and refstep > :refstep";
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("ref",ref);
		param.put("refstep",refstep);
		template.update(sql, param);
		
	}

	public void updateboard(Board board) {
		String sql = "update board set name=:name,subject=:subject,content=:content,file1=:fileurl where num=:num";
		SqlParameterSource param = new BeanPropertySqlParameterSource(board);
		template.update(sql, param);
	}

	public void deleteBoard(Integer num) {
		String sql="delete from board where num=:num";
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("num",num);
		template.update(sql, param);
		
	}


	
}
