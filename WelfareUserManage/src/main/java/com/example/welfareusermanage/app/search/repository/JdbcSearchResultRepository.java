package com.example.welfareusermanage.app.search.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.welfareusermanage.app.search.entity.searchForm;
import com.example.welfareusermanage.app.search.entity.searchResult;

@Repository
public class JdbcSearchResultRepository implements SearchResultRepository{

	private JdbcTemplate jdbcTemplate;
	
	public JdbcSearchResultRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	@Override
	public List<searchResult> search(searchForm form) {
		// TODO 自動生成されたメソッド・スタブ
		String sql = "SELECT * FROM (\n"
				+ "SELECT U_NAME,\n"
				+ "EXTRACT(YEAR FROM SYSDATE)-EXTRACT(YEAR FROM UT.BIRTH_DATE)\n"
				+ "-CASE WHEN\n"
				+ "TO_CHAR(SYSDATE,'MM/DD')<TO_CHAR(UT.BIRTH_DATE,'MM/DD') THEN 1 ELSE 0\n"
				+ "END AS AGE,\n"
				+ "CL_NAME,\n"
				+ "CONCAT(CONCAT(R_NAME,cim.c_name),HOUSE) AS HOUSE_ADDRESS,\n"
				+ "LISTAGG(WT_NAME,',') AS TOOLS,\n"
				+ "chm.c_name,MONI_MONTH\n"
				+ "FROM USERS_TBL UT\n"
				+ "LEFT JOIN CARE_LEVEL_MST CLM ON clm.care_level_no = ut.care_level_no\n"
				+ "LEFT JOIN CITY_MST CIM ON cim.city_code = ut.city_code\n"
				+ "LEFT JOIN REGION_MST REM ON rem.region_code = cim.region_code\n"
				+ "LEFT JOIN CHARGE_MST CHM ON chm.charge_id = ut.charge_id\n"
				+ "RIGHT JOIN WELFARE_TOOL_USER_TBL WTUT ON wtut.user_id = ut.user_id\n"
				+ "LEFT JOIN WELFARE_TOOL_MST WTM ON wtm.welfare_tool_no = wtut.welfare_tool_no \n"
				+ "WHERE\n"
				+ "    (? is null or UT.USER_ID = ?)\n"
				+ "AND (? is null or UT.gender = ?)\n"
				+ "AND (? IS NULL OR cim.region_code LIKE CONCAT(?,'%'))\n"
				+ "AND (? IS NULL OR cim.city_code LIKE CONCAT(?,'%'))\n"
				+ "AND (? IS NULL OR HOUSE LIKE CONCAT(?,'%'))\n"
				+ "AND (? IS NULL OR ? IS NULL OR clm.care_level_no BETWEEN concat('0',?) AND concat('0',?))\n"
				+ "group by U_NAME, \n"
				+ "EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM UT.BIRTH_DATE) \n"
				+ "- CASE WHEN TO_CHAR(SYSDATE,'MM/DD') < TO_CHAR(UT.BIRTH_DATE,'MM/DD') THEN 1 ELSE 0 END,\n"
				+ "CL_NAME, CONCAT(CONCAT(R_NAME,cim.c_name),HOUSE), chm.c_name, MONI_MONTH\n"
				+ ") T\n"
				+ "WHERE\n"
				+ "    (? IS NULL OR U_NAME LIKE CONCAT(CONCAT('%',?),'%'))\n"
				+ "AND ((? IS NULL OR ? IS NULL) OR AGE BETWEEN ? AND ?)\n"
				+ "AND (? IS NULL OR C_NAME LIKE CONCAT(CONCAT('%',?),'%'))\n"
				+ "AND ((? IS NULL or ? is null) OR MONI_MONTH = concat(?,concat('/',?)) )\n"
				+ "AND (? IS NULL OR TOOLS = ?)"
				+ "";
		return getJdbcTemplate().query(
				sql,(resultSet,i) -> {
					searchResult item = new searchResult();
					item.setUName(resultSet.getString("u_name"));
					item.setAge(resultSet.getInt("age"));
					item.setClName(resultSet.getString("cl_name"));
					item.setHouseaddress(resultSet.getString("HOUSE_ADDRESS"));
					item.setWtName(resultSet.getString("tools"));
					item.setCName(resultSet.getString("c_name"));
					item.setMoniMonths(resultSet.getString("MONI_MONTH"));
					return item;
				}
				,form.getUserId(),form.getUserId()
				,form.getGender(),form.getGender()
				,form.getRegionCode(),form.getRegionCode()
				,form.getCityCode(),form.getCityCode()
				,form.getHouse(),form.getHouse()
				,form.getCareLevelFrom(),form.getCareLevelTo(),form.getCareLevelFrom(),form.getCareLevelTo()
				,form.getUName(),form.getUName()
				,form.getAgeFrom(),form.getAgeTo(),form.getAgeFrom(),form.getAgeTo()
				,form.getCName(),form.getCName()
				,form.getMoniY(),form.getMoniM(),form.getMoniY(),form.getMoniM()
				,form.getTools(),form.getTools()
			);
	}
	
}
