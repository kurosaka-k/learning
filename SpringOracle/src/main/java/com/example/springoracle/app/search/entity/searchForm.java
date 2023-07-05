package com.example.springoracle.app.search.entity;

import lombok.Data;

@Data
public class searchForm {
//	利用者ID
	private String userId;
//	利用者名
	private String uName;
//	年齢from
	private Integer ageFrom;
//	年齢to
	private Integer ageTo;
//	性別
	private String gender;
//	市区町村コード
	private String cityCode;
//	住所
	private String house;
//	介護度from
	private String careLevelFrom;
//	介護度to
	private String careLevelTo;
//	担当者名
	private String cName;
//	モニタリングの年
	private String moniY;
//	モニタリングの月
	private String moniM;
//	福祉用具（複数）
	private String tools;
}
