package com.example.welfareusermanage.table.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.welfareusermanage.table.entity.CareMgrMst;
import com.example.welfareusermanage.table.repository.interfaces.CareMgrMstRepository;

@Repository
public class JdbcCareMgrMstRepository implements CareMgrMstRepository{

	private JdbcTemplate jdbcTemplate;
	
	public JdbcCareMgrMstRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Override
	public List<CareMgrMst> find() {
		// TODO 自動生成されたメソッド・スタブ
		return getJdbcTemplate().query(
				"select * from care_mgr_mst",(resultSet,i) -> {
					CareMgrMst item = new CareMgrMst();
					item.setCareMgrId(resultSet.getString("care_mgr_id"));
					item.setCmName(resultSet.getString("cm_name"));
					item.setHomeSerOfficeNo(resultSet.getString("home_ser_office_no"));
					return item;
		});
	}
}
