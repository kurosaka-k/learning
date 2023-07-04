package com.example.springoracle.app.sample.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.springoracle.table.entity.CareLevelMst;
@Repository
public class JdbcCareLevelMstRepository implements CareLevelMstRepository{

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcCareLevelMstRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<CareLevelMst> find() {
		// TODO 自動生成されたメソッド・スタブ
		
		return getJdbcTemplate().query(
				"SELECT * FROM CARE_LEVEL_MST",(resultSet,i) -> {
					CareLevelMst item = new CareLevelMst();
					item.setCareLevelNo(resultSet.getString("Care_Level_No"));
					item.setClName(resultSet.getString("cl_name"));
					return item;
				}
				);
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
}
