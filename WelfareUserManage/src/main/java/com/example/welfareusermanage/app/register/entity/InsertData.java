package com.example.welfareusermanage.app.register.entity;

import lombok.Data;

@Data
public class InsertData {
//	利用者名
	private String uName;
//	生年月日
	private String birthDate;
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
//	担当者ID
	private String chargeId;
//	ケアマネージャーID
	private String careMgrId;
//	福祉用具No+名
	private String toolsCode;
	
}
