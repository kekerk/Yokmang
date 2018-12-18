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


import logic.SaleItem;

@Repository
public class SaleItemDao {
	private NamedParameterJdbcTemplate template;
	private RowMapper<SaleItem> mapper = new BeanPropertyRowMapper<SaleItem>(SaleItem.class);

	@Autowired
	public void setDataSource(DataSource dataSource) {
		template = new NamedParameterJdbcTemplate(dataSource);
	}
	public void insert(SaleItem is) {
		String sql = "insert into saleitem (saleid,saleitemid,itemid,quantity,updatetime)"
					 + " values (:saleId,:saleItemId,:item.id,:quantity,:updateTime)";
		SqlParameterSource param = new BeanPropertySqlParameterSource(is);
		template.update(sql, param);
		
	}
	public List<SaleItem> SaleItemlist(Integer saleId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("saleId", saleId);
		return template.query("select * from saleitem where saleid=:saleId", map, mapper);
	}

}
