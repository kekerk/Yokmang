package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import logic.Item;

public class ItemDaoImpl implements ItemDao {
	private NamedParameterJdbcTemplate template;

	public void setDataSource(DataSource dataSource) {
		this.template = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public List<Item> itemList() {
		String sql = "select * from item";
		/*
		 * mapper :	Item ��ü�� ������Ƽ�� �÷����� ���� ������ Item ��ü�� ���� 
		 * 		Item item = new Item();
		 * 		item.setId(rs.getString("id"));
		 * 		item.setName(rs.getString("name"));
		 * 		...
		 */
		RowMapper<Item> mapper = new BeanPropertyRowMapper<Item>(Item.class);
		return template.query(sql, mapper);	// List���·� ����
	}

	@Override
	public Item getItemById(Integer id) {
		String sql = "select * from item where id = :id";
		RowMapper<Item> mapper = new BeanPropertyRowMapper<Item>(Item.class);
		Map<String, Integer> param = new HashMap<String, Integer>();
		param.put("id", id);
		return template.queryForObject(sql, param, mapper);	// �ϳ��� Object ���·� ����
	}

}
