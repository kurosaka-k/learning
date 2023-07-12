package com.example.welfareusermanage.app.change.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.welfareusermanage.app.change.entity.ChangeForm;

@Repository
public class JdbcChangeRepository implements ChangeRepository{
	private JdbcTemplate jdbcTemplate;
	
	public JdbcChangeRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Override
	public ChangeForm find(String userId) {
		String sql = "SELECT U_NAME,UT.USER_ID,UT.BIRTH_DATE,\n"
				+ "UT.GENDER,\n"
				+ "cim.region_code,cim.city_code,ut.house,\n"
				+ "ut.care_level_no,\n"
				+ "CONCAT(CHM.C_NAME,CONCAT('(',CONCAT(CHM.CHARGE_ID,')'))) AS \"charge\",\n"
				+ "MONI_MONTH,\n"
				+ "ADL,\n"
				+ "CONCAT(cm_name,CONCAT('(',CONCAT(cmm.care_mgr_ID,')'))) AS \"care_mgr\",\n"
				+ "CONCAT(o_name,CONCAT('(',CONCAT(hsom.home_ser_office_no,')'))) AS \"office\",\n"
				+ "LISTAGG(WT_NAME,',') AS TOOLS\n"
				+ "FROM USERS_TBL UT\n"
				+ "LEFT JOIN CITY_MST CIM ON CIM.CITY_CODE = UT.CITY_CODE\n"
				+ "LEFT JOIN REGION_MST RMS ON RMS.REGION_CODE = CIM.REGION_CODE\n"
				+ "LEFT JOIN CARE_LEVEL_MST CLM ON CLM.CARE_LEVEL_NO = UT.CARE_LEVEL_NO\n"
				+ "LEFT JOIN CHARGE_MST CHM ON CHM.CHARGE_ID = UT.CHARGE_ID\n"
				+ "LEFT JOIN CARE_MGR_MST CMM ON CMM.CARE_MGR_ID = UT.CARE_MGR_ID\n"
				+ "LEFT JOIN HOME_SER_OFFICE_MST HSOM ON HSOM.HOME_SER_OFFICE_NO = CMM.HOME_SER_OFFICE_NO\n"
				+ "RIGHT JOIN WELFARE_TOOL_USER_TBL WTUT ON WTUT.USER_ID = UT.USER_ID\n"
				+ "LEFT JOIN WELFARE_TOOL_MST WTM ON WTM.WELFARE_TOOL_NO = WTUT.WELFARE_TOOL_NO\n"
				+ "group by U_NAME,UT.USER_ID,UT.BIRTH_DATE,\n"
				+ "UT.GENDER,\n"
				+ "cim.region_code,cim.city_code,ut.house,\n"
				+ "ut.care_level_no,\n"
				+ "CONCAT(CHM.C_NAME,CONCAT('(',CONCAT(CHM.CHARGE_ID,')'))),\n"
				+ "MONI_MONTH,\n"
				+ "ADL,\n"
				+ "CONCAT(cm_name,CONCAT('(',CONCAT(cmm.care_mgr_ID,')'))),\n"
				+ "CONCAT(o_name,CONCAT('(',CONCAT(hsom.home_ser_office_no,')')))\n"
				+ "having ut.user_id = ?";
		// TODO 自動生成されたメソッド・スタブ
		return getJdbcTemplate().queryForObject(
				sql, (resultSet,i) -> {
					ChangeForm item = new ChangeForm();
					item.setUserId(resultSet.getString("user_id"));
					item.setUName(resultSet.getString("u_name"));
					item.setBirthDate(resultSet.getString("birth_Date").substring(0,10));
					item.setGender(resultSet.getString("gender"));
					item.setRegionCode(resultSet.getString("region_code"));
					item.setCityCode(resultSet.getString("city_code"));
					item.setHouse(resultSet.getString("house"));
					item.setCareLevelNo(resultSet.getInt("care_level_no"));
					item.setCharge(resultSet.getString("charge"));
					item.setMoniY(resultSet.getString("moni_month").substring(0,4));
					item.setMoniM(resultSet.getString("moni_month").substring(5,6));
					item.setAdl(resultSet.getString("adl"));
					item.setHomeSerOffice(resultSet.getString("office"));
					item.setCareMgr(resultSet.getString("care_mgr"));
					item.setTools(resultSet.getString("tools"));
					return item;
				},userId);
	}
	
	
}
