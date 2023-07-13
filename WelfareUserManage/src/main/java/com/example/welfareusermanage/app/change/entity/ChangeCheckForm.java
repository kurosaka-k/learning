package com.example.welfareusermanage.app.change.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data
public class ChangeCheckForm {
	private String userId;
//	利用者名
	private String uName;
//	生年月日
	private String birthDate;
	private Integer age;
//	性別
	private String gender;
//	市区町村コード
	private String cityCode;
//	住所
	private String house;
//	ADL
	private String adl;
//	モニタリング月
	private String moni;
//	要介護度
	private String careLevelNo;
//	担当者名+ID
	private String chargeId;
	private String cName;
//	居宅サービス事務所No+名
	private String homeSerOfficeNo;
	private String oName;
//	ケアマネージャー名+ID
	private String careMgrId;
	private String cmName;
//	福祉用具No+名
	private String toolsCode;
	private String tools;
	
	
	public ChangeCheckForm(ChangeForm form){
		setUserId(form.getUserId());
		setUName(form.getUName());
		setBirthDate(form.getBirthDate());
		setAge(form.getBirthDate());
		setGender(form.getGender());
		setCityCode(form.getCityCode());
		setHouse(form.getHouse());
		setAdl(form.getAdl());
		setMoni(form.getMoniY() + "/" + form.getMoniM());
		setCareLevelNo(form.getCareLevelNo());
		setChargeId(form.getCharge());
		setCName(form.getCharge());
		setHomeSerOfficeNo(form.getHomeSerOffice());
		setOName(form.getHomeSerOffice());
		setCareMgrId(form.getCareMgr());
		setCmName(form.getCareMgr());
		if(form.getTools().indexOf(",") == -1) {
			setToolsCode(form.getTools());
			setTools(form.getTools());
		}else {
			String[] split = form.getTools().split(",");
			for(String str : split) {
				setToolsCode(str);
				setTools(str);
			}
		}
			
	}
	public void setCareLevelNo(String careLevelNo) {
		this.careLevelNo = "0"+careLevelNo;
	}
	public void setChargeId(String charge) {
		this.chargeId = itemCode(charge);
	}
	public void setCName(String charge) {
		this.cName = itemName(charge);
	}
	public void setHomeSerOfficeNo(String homeSerOffice) {
		this.homeSerOfficeNo = itemCode(homeSerOffice);
	}
	public void setOName(String homeSerOffice) {
		this.oName = itemName(homeSerOffice);
	}
	public void setCareMgrId(String careMgr) {
		this.careMgrId = itemCode(careMgr);
	}
	public void setCmName(String careMgr) {
		this.cmName = itemName(careMgr);
	}
	
	public void setTools(String tools) {
		if(this.tools == null) {
			this.tools = itemName(tools);			
		}else {
			this.tools += ","+itemName(tools);
		}
	}
	public void setToolsCode(String tools) {
		if(this.toolsCode == null) {
			this.toolsCode = itemCode(tools);
		}else {
			this.toolsCode += ","+itemCode(tools);
		}
	}
	public void setAge(String birthDate){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		try {
			Date birthday = sdf.parse(birthDate);
			
			Date now = new Date();
			this.age = calcAge(birthday,now);
			
		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
	}
	String itemCode(String str) {
		int startPoint = str.indexOf("(")+1;
		int endPoint = str.indexOf(")");
		String item = str.substring(startPoint,endPoint);
		return item;
	}
	String itemName(String str) {
		int endPoint = str.indexOf("(");
		String item = str.substring(0,endPoint);
		return item;
	}
	public static int calcAge(Date birthday, Date now) {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	    return (Integer.parseInt(sdf.format(now)) - Integer.parseInt(sdf.format(birthday))) / 10000;
	}
}
