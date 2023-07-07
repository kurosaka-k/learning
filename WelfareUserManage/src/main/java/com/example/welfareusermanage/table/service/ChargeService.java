package com.example.welfareusermanage.table.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.welfareusermanage.table.entity.ChargeMst;
import com.example.welfareusermanage.table.repository.interfaces.ChargeMstRepository;

@Service
public class ChargeService {
	private ChargeMstRepository cmRepository;
	
	public ChargeService(ChargeMstRepository cmRepository) {
		this.cmRepository = cmRepository;
	}
	
	public ChargeMstRepository getCmRepository() {
		return cmRepository;
	}
	
	public List<ChargeMst> readAll(){
		return getCmRepository().find();
	}
}
