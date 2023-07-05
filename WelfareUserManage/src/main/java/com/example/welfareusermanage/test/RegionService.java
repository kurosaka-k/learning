package com.example.welfareusermanage.test;

import java.util.List;

import org.springframework.stereotype.Service;

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
