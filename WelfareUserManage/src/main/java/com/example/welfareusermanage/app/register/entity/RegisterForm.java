package com.example.welfareusermanage.app.register.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class RegisterForm {
//	利用者名
	@NotBlank
	private String uName;
//	生年月日
	@NotBlank
	private String birthDate;
//	性別
	@NotEmpty
	private String gender;
//	市区町村コード
	@NotEmpty
	private String cityCode;
//	住所
	@NotBlank
	private String house;
//	ADL
	@NotBlank
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
	@NotBlank
	private String chargeId;
//	居宅サービス事務所No+名
	@NotBlank
	private String homeSerOffice;
//	ケアマネージャー名+ID
	@NotBlank
	private String careMgrId;
//	福祉用具(複数)
	@NotEmpty
	private String tools;
}
