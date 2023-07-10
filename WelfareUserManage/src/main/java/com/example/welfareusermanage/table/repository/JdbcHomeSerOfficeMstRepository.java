package com.example.welfareusermanage.table.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.welfareusermanage.table.entity.HomeSerOfficeMst;
import com.example.welfareusermanage.table.repository.interfaces.HomeSerOfficeMstRepository;

@Repository
public class JdbcHomeSerOfficeMstRepository implements HomeSerOfficeMstRepository{
	private JdbcTemplate jdbcTemplate;
	
	public JdbcHomeSerOfficeMstRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	@Override
	public List<HomeSerOfficeMst> find() {
		// TODO 自動生成されたメソッド・スタブ
		return getJdbcTemplate().query(
				"select * from home_ser_office_mst", (resultSet,i) -> {
				HomeSerOfficeMst item = new HomeSerOfficeMst();
				item.setHomeSerOfficeNo(resultSet.getString("home_ser_office_no"));
				item.setOName(resultSet.getString("o_name"));
				item.setCityCode(resultSet.getString("city_code"));
				item.setHouse(resultSet.getString("house"));
				return item;	
		});
	}
	
	
}
