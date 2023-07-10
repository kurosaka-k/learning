package com.example.welfareusermanage.table.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.welfareusermanage.table.entity.HomeSerOfficeMst;
import com.example.welfareusermanage.table.repository.interfaces.HomeSerOfficeMstRepository;

@Service
public class HomeSerOfficeService {
	private HomeSerOfficeMstRepository hsomRepository;
	
	public HomeSerOfficeService(HomeSerOfficeMstRepository hsomRepository) {
		this.hsomRepository = hsomRepository;
	}
	
	public HomeSerOfficeMstRepository getHsomRepository() {
		return hsomRepository;
	}
	
	public List<HomeSerOfficeMst> readAll(){
		return getHsomRepository().find();
	}
	
}
