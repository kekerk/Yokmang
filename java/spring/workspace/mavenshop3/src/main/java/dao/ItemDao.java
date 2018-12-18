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

import logic.Item;

/*
 *  @Component + model의 기능 부여.
 */
@Repository
public class ItemDao {
	
	private NamedParameterJdbcTemplate template;
	
	private RowMapper<Item> mapper = new BeanPropertyRowMapper<Item>(Item.class);
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		template = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<Item> list(){
		return template.query("select * from item order by id",mapper); // mapper로 인해 List 형태로 리턴을 가지게 됨.
	}
	
	public Item getItemById(Integer id) {
		String sql = "select * from item where id = :id";
		Map<String, Integer> param = new HashMap<String, Integer>();
		param.put("id", id);
		return template.queryForObject(sql, param, mapper); //조회시 필요. resultSet 발생시킴. 
	}
	
	public void insert(Item item) {
		// i : item 테이블의 id 값의 최대값 저장
		int i = template.queryForObject("select ifnull(max(id),0) from item", new HashMap<String,Object>(), Integer.class); //  new HashMap<String,Object>() : 자료형 완성을 위해 집어넣음
		item.setId(++i); //새로 등록할 레코드의 id값 설정.
		String sql = "insert into item (id,name,price,description,pictureUrl)" + "values(:id,:name,:price,:description,:pictureUrl)";
		SqlParameterSource param = new BeanPropertySqlParameterSource(item);
		template.update(sql, param);
	}

	public void update(Item item) {
		String sql = "update item set name=:name, price=:price, description=:description, pictureUrl=:pictureUrl where id=:id";
		SqlParameterSource param = new BeanPropertySqlParameterSource(item);
		template.update(sql, param);
	}

	public void delete(Integer id) {
		String sql = "delete from item where id = :id";
		Map<String, Integer> param = new HashMap<String, Integer>();
		param.put("id", id);
		template.update(sql, param);//삭제,추가,수정 관련
	}
}
