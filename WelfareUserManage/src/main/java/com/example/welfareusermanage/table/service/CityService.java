package com.example.welfareusermanage.table.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.welfareusermanage.table.entity.CityMst;
import com.example.welfareusermanage.table.repository.interfaces.CityMstRepository;

@Service
public class CityService {
	private CityMstRepository cmRepository;
	
	public CityService(CityMstRepository cmRepository) {
		this.cmRepository = cmRepository;
	}
	
	public CityMstRepository getcmRepository() {
		return cmRepository;
	}
	
	public List<CityMst> readAll(){
		return getcmRepository().find();
	}
	
}
