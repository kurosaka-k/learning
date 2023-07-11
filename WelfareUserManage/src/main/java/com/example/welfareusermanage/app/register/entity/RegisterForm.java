package com.example.welfareusermanage.app.register.entity;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class RegisterForm {
//	利用者名
	@NotEmpty
	private String uName;
//	生年月日
	@NotEmpty
	private String birthDate;
//	性別
	@NotEmpty
	private String gender;
//	市区町村コード
	@NotEmpty
	private String cityCode;
//	住所
	@NotEmpty
	private String house;
//	ADL
	@NotEmpty
	private String adl;
//	モニタリング月
	@NotEmpty
	private String moniY;
	@NotEmpty
	private String moniM;
//	要介護度
	@NotEmpty
	private String careLevelNo;
//	担当者ID
	@NotEmpty
	private String chargeId;
//	居宅サービス事務所No+名
	@NotEmpty
	private String homeSerOffice;
//	ケアマネージャー名+ID
	@NotEmpty
	private String careMgrId;
//	福祉用具(複数)
	@NotEmpty
	private String tools;
	
}
