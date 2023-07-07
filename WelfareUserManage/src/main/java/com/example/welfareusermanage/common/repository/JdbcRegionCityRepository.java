package com.example.welfareusermanage.common.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.welfareusermanage.common.entity.RegionCity;

@Repository
public class JdbcRegionCityRepository implements RegionCityRepository{

	private JdbcTemplate jdbcTemplate;
	
	public JdbcRegionCityRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	@Override
	public List<RegionCity> find() {
		// TODO 自動生成されたメソッド・スタブ
		return getJdbcTemplate().query(
				"select cm.city_code,cm.c_name,cm.region_code,r_name from city_mst cm "
				+ "left join region_mst rm on cm.region_code = rm.region_code"
				,(resultSet,i)->{
					RegionCity item = new RegionCity();
					item.setCityCode(resultSet.getString("city_code"));
					item.setCName(resultSet.getString("c_name"));
					item.setRegionCode(resultSet.getString("region_code"));
					item.setRName(resultSet.getString("r_name"));
					return item;
		});
	}
	
}
