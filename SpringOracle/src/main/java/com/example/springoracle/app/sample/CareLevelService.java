package com.example.springoracle.app.sample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springoracle.table.entity.CareLevelMst;

@Service
public class CareLevelService {
	private CareLevelMstRepository clmRepository;
	
	@Autowired
	public CareLevelService(CareLevelMstRepository clmRepository) {
		this.clmRepository = clmRepository;
	}
	
	public List<CareLevelMst> readAll(){
		return getClmRepository().find();
	}
	
	public CareLevelMstRepository getClmRepository() {
		return clmRepository;
	}
}
