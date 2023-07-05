package com.example.welfareusermanage.test;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class JdbcRegionMstRepository implements RegionMstRepository{

	private JdbcTemplate jdbcTemplate;
	
	public JdbcRegionMstRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<RegionMst> find() {
		// TODO 自動生成されたメソッド・スタブ
		return getJdbcTemplate().query(
				"select * from REGION_MST",(resultSet,i) -> {
					RegionMst item = new RegionMst();
					item.setRegionCode(resultSet.getString("REGION_CODE"));
					item.setRName(resultSet.getString("R_NAME"));
					return item;
				}
				);
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

}
