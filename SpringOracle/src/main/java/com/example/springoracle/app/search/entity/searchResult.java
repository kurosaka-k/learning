package com.example.springoracle.app.search.entity;

import lombok.Data;

@Data
public class searchResult {
//	利用者名
	private String uName;
//	年齢
	private Integer age;
//	介護度名
	private String clName;
//	都道府県＋市区町村＋住所
	private String houseaddress;
//	福祉用具(カンマ区切り)
	private String wtName;
//	担当者名
	private String cName;
//	モニタリング月(年月）
	private String moniMonths;
}
