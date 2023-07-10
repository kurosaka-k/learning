package com.example.welfareusermanage.table.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.welfareusermanage.table.entity.CareMgrMst;
import com.example.welfareusermanage.table.repository.interfaces.CareMgrMstRepository;

@Service
public class CareMgrService {
	private CareMgrMstRepository cmmRepository;
	
	public CareMgrService(CareMgrMstRepository cmmRepository) {
		this.cmmRepository = cmmRepository;
	}
	
	public CareMgrMstRepository getCmmRepository() {
		return cmmRepository;
	}
	
	public List<CareMgrMst> readAll(){
		return getCmmRepository().find();
	}
}
