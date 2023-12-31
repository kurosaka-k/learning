package com.example.welfareusermanage.table.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.welfareusermanage.app.change.entity.ToolsChecked;
import com.example.welfareusermanage.table.entity.WelfareToolMst;
import com.example.welfareusermanage.table.repository.interfaces.WelfareToolMstRepository;

@Repository
public class JdbcWelfareToolMstRepository implements WelfareToolMstRepository{

	private JdbcTemplate jdbcTemplate;
	
	public JdbcWelfareToolMstRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	@Override
	public List<WelfareToolMst> find() {
		// TODO 自動生成されたメソッド・スタブ
		return getJdbcTemplate().query(
				"select * from welfare_tool_mst",(resultSet,i) -> {
					WelfareToolMst item = new WelfareToolMst();
					item.setWelfareToolNo(resultSet.getString("welfare_tool_no"));
					item.setWtName(resultSet.getString("wt_name"));
					return item;
				});
	}

	@Override
	public List<ToolsChecked> check() {
		// TODO 自動生成されたメソッド・スタブ
		return getJdbcTemplate().query(
				"select * from welfare_tool_mst",(resultSet,i) -> {
					ToolsChecked item = new ToolsChecked();
					item.setWelfareToolNo(resultSet.getString("welfare_tool_no"));
					item.setWtName(resultSet.getString("wt_name"));
					return item;
				});
	}
	
	
}
