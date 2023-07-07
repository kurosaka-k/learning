package com.example.welfareusermanage.table.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.welfareusermanage.table.entity.RegionMst;
import com.example.welfareusermanage.table.repository.interfaces.RegionMstRepository;

@Service
public class RegionService {
	private RegionMstRepository rmRepository;
	
	public RegionService(RegionMstRepository rmRepository) {
		this.rmRepository = rmRepository;
	}
	
	public RegionMstRepository getRmRepository() {
		return rmRepository;
	}
	
	public List<RegionMst> readAll(){
		return getRmRepository().find();
	}
}
