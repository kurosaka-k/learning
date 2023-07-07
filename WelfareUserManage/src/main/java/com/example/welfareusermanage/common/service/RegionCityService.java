package com.example.welfareusermanage.common.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.welfareusermanage.common.entity.RegionCity;
import com.example.welfareusermanage.common.repository.RegionCityRepository;

@Service
public class RegionCityService {
	private RegionCityRepository rcRepository;
	
	public RegionCityService(RegionCityRepository rcRepository) {
		this.rcRepository = rcRepository;
	}
	
	public RegionCityRepository getRcRepository() {
		return rcRepository;
	}
	
	public List<RegionCity> readAll(){
		return getRcRepository().find();
	}
}
