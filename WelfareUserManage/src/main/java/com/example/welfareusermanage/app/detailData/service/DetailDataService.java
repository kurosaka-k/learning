package com.example.welfareusermanage.app.detailData.service;

import org.springframework.stereotype.Service;

import com.example.welfareusermanage.app.detailData.entity.DetailDataForm;
import com.example.welfareusermanage.app.detailData.repository.DetailDataFormRepository;

@Service
public class DetailDataService {
	private DetailDataFormRepository ddfRepository;
	
	public DetailDataService(DetailDataFormRepository ddfRepository) {
		this.ddfRepository = ddfRepository;
	}
	
	public DetailDataFormRepository getDdfRepository() {
		return ddfRepository;
	}
	
	public DetailDataForm read(String userId){
		return getDdfRepository().find(userId);
	}
}
