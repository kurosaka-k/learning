package com.example.welfareusermanage.table.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.welfareusermanage.table.entity.CityMst;
import com.example.welfareusermanage.table.repository.interfaces.CityMstRepository;

@Repository
public class JdbcCityMstRepository implements CityMstRepository{

	private JdbcTemplate jdbcTemplate;
	
	public JdbcCityMstRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	@Override
	public List<CityMst> find() {
		// TODO 自動生成されたメソッド・スタブ
		return getJdbcTemplate().query(
				"select * from city_Mst",(resultSet,i) ->{
					CityMst item = new CityMst();
					item.setCityCode(resultSet.getString("City_Code"));
					item.setCName(resultSet.getString("c_Name"));
					item.setRegionCode(resultSet.getString("Region_Code"));
					return item;
				}
				);
	}

}
