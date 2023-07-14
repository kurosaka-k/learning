package com.example.welfareusermanage.table.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.welfareusermanage.app.change.entity.ToolsChecked;
import com.example.welfareusermanage.table.entity.WelfareToolMst;
import com.example.welfareusermanage.table.repository.interfaces.WelfareToolMstRepository;

@Service
public class WelfareToolService {
	private WelfareToolMstRepository wtmRepository;
	
	public WelfareToolService(WelfareToolMstRepository wtmRepository) {
		this.wtmRepository = wtmRepository;
	}
	
	public WelfareToolMstRepository getwtmRepository() {
		return wtmRepository;
	}
	
	public List<WelfareToolMst> readAll(){
		return getwtmRepository().find();
	}
	
	public List<ToolsChecked> readchecked(){
		return getwtmRepository().check();
	}
}
