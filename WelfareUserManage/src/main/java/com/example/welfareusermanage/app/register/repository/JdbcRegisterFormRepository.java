package com.example.welfareusermanage.app.register.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.welfareusermanage.app.register.entity.InsertData;

@Repository
public class JdbcRegisterFormRepository implements RegisterFormRepository{

	private JdbcTemplate jdbcTemplate;
	
	public JdbcRegisterFormRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	@Override
	public void insert(InsertData form) {
		// TODO 自動生成されたメソッド・スタブ
		getJdbcTemplate().update(
				"CALL INSERT_USER(?,?,?,?,?,?,?,?,?,?,?)",
				form.getUName(),form.getBirthDate(),form.getGender()
				,form.getCityCode(),form.getHouse(),form.getAdl()
				,form.getMoni(),form.getCareLevelNo()
				,form.getChargeId(),form.getCareMgrId(),form.getToolsCode()
				);
	}
	
}
