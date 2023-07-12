package com.example.welfareusermanage.app.detailData.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.welfareusermanage.app.detailData.entity.DetailDataForm;

@Repository
public class JdbcDetailDataFormRepository implements DetailDataFormRepository {

	private JdbcTemplate jdbcTemplate;

	public JdbcDetailDataFormRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public DetailDataForm find(String userId) {
		return getJdbcTemplate().queryForObject(
				"SELECT U_NAME,UT.USER_ID,UT.BIRTH_DATE,\n"
						+ "EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM UT.BIRTH_DATE)\n"
						+ "- CASE WHEN\n"
						+ "TO_CHAR(SYSDATE,'MM/DD') < TO_CHAR(UT.BIRTH_DATE,'MM/DD')\n"
						+ "THEN 1 ELSE 0\n"
						+ "END AS AGE,\n"
						+ "CASE UT.GENDER\n"
						+ "WHEN '1' THEN '男'\n"
						+ "ELSE '女' END GENDER,\n"
						+ "CONCAT(CONCAT(R_NAME,cim.c_name),UT.HOUSE) AS HOUSE_ADDRESS,\n"
						+ "CL_NAME,\n"
						+ "CONCAT(CHM.C_NAME,CONCAT('(',CONCAT(CHM.CHARGE_ID,')'))) AS \"C_NAME\",\n"
						+ "MONI_MONTH,\n"
						+ "LISTAGG(WT_NAME,',') AS TOOLS,\n"
						+ "ADL,CM_NAME,O_NAME\n"
						+ "FROM USERS_TBL UT\n"
						+ "LEFT JOIN CITY_MST CIM ON CIM.CITY_CODE = UT.CITY_CODE\n"
						+ "LEFT JOIN REGION_MST RMS ON RMS.REGION_CODE = CIM.REGION_CODE\n"
						+ "LEFT JOIN CARE_LEVEL_MST CLM ON CLM.CARE_LEVEL_NO = UT.CARE_LEVEL_NO\n"
						+ "LEFT JOIN CHARGE_MST CHM ON CHM.CHARGE_ID = UT.CHARGE_ID\n"
						+ "LEFT JOIN CARE_MGR_MST CMM ON CMM.CARE_MGR_ID = UT.CARE_MGR_ID\n"
						+ "LEFT JOIN HOME_SER_OFFICE_MST HSOM ON HSOM.HOME_SER_OFFICE_NO = CMM.HOME_SER_OFFICE_NO\n"
						+ "RIGHT JOIN WELFARE_TOOL_USER_TBL WTUT ON WTUT.USER_ID = UT.USER_ID\n"
						+ "LEFT JOIN WELFARE_TOOL_MST WTM ON WTM.WELFARE_TOOL_NO = WTUT.WELFARE_TOOL_NO\n"
						+ "group by U_NAME, UT.USER_ID, UT.BIRTH_DATE, EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM UT.BIRTH_DATE) - CASE WHEN TO_CHAR(SYSDATE,'MM/DD') < TO_CHAR(UT.BIRTH_DATE,'MM/DD') THEN 1 ELSE 0 END, CASE UT.GENDER WHEN '1' THEN '男' ELSE '女' END, \n"
						+ "CONCAT(CONCAT(R_NAME,cim.c_name),UT.HOUSE), CL_NAME, CONCAT(CHM.C_NAME,CONCAT('(',CONCAT(CHM.CHARGE_ID,')'))), MONI_MONTH, ADL, \n"
						+ "CM_NAME, O_NAME\n"
						+ "HAVING\n"
						+ "UT.USER_ID = ?",
				(resultSet, i) -> {
					DetailDataForm item = new DetailDataForm();
					item.setUName(resultSet.getString("u_name"));
					item.setUserId(resultSet.getString("user_id"));
					item.setBirthDate(resultSet.getString("birth_date").substring(0,10));
					item.setAge(resultSet.getInt("age"));
					item.setGender(resultSet.getString("gender"));
					item.setHouseAddress(resultSet.getString("house_address"));
					item.setCareLevelName(resultSet.getString("cl_name"));
					item.setChargeName(resultSet.getString("c_name"));
					item.setMoni(resultSet.getString("moni_month"));
					item.setTools(resultSet.getString("tools"));
					item.setAdl(resultSet.getString("adl"));
					item.setCareMgrName(resultSet.getString("cm_name"));
					item.setOfficeName(resultSet.getString("o_name"));
					return item;
				}, userId);
	}
}
