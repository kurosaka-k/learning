package com.example.welfareusermanage.table.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.welfareusermanage.table.entity.ChargeMst;
import com.example.welfareusermanage.table.repository.interfaces.ChargeMstRepository;

@Repository
public class JdbcChargeMstRepository implements ChargeMstRepository{
	private JdbcTemplate jdbcTemplate;

	public JdbcChargeMstRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	@Override
	public List<ChargeMst> find() {
		// TODO 自動生成されたメソッド・スタブ
		return getJdbcTemplate().query(
				"select * from charge_mst", (resultSet,i) -> {
					ChargeMst item = new ChargeMst();
					item.setChargeId(resultSet.getString("charge_id"));
					item.setCName(resultSet.getString("c_name"));
					item.setBirthDate(resultSet.getString("birth_date"));
					item.setGender(resultSet.getString("gender"));
					return item;
		});
	}
	
	
}
