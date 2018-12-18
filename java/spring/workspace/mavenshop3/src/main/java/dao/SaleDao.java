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

import logic.Sale;
import logic.SaleItem;

@Repository
public class SaleDao {
	private NamedParameterJdbcTemplate template;
	private RowMapper<Sale> mapper = new BeanPropertyRowMapper<Sale>(Sale.class);

	@Autowired
	public void setDataSource(DataSource dataSource) {
		template = new NamedParameterJdbcTemplate(dataSource);
	}
	public Integer getMaxSaleId() {
		String sql = "select ifnull(max(saleid),0) from sale";
		Integer ret = template.queryForObject(sql, new HashMap(), Integer.class);
		return ret;
	}

	public void insert(Sale sale) {
		String sql = "insert into sale (saleid,userid,updatetime) values (:saleId, :user.userId, :updateTime)";
		SqlParameterSource param = new BeanPropertySqlParameterSource(sale);
		template.update(sql, param);
		
	}
	public List<Sale> Salelist(String id) {
		String sql = "select * from sale where userid=:userId";
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userId", id);
		return template.query(sql, map, mapper);
	}
	

}
