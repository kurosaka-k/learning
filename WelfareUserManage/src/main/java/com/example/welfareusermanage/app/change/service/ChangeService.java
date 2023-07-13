package com.example.welfareusermanage.app.change.service;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.welfareusermanage.app.change.entity.ChangeCheckForm;
import com.example.welfareusermanage.app.change.entity.ChangeForm;
import com.example.welfareusermanage.app.change.entity.UpdateData;
import com.example.welfareusermanage.app.change.repository.ChangeRepository;

@Service
public class ChangeService {
	@Autowired
	private ChangeRepository changerepository;
	
	public ChangeForm read(String userId) {
		return changerepository.find(userId);
	}
	
	public ChangeCheckForm convert(ChangeForm form) {
		ChangeCheckForm item = new ChangeCheckForm(form);
		return item;
	}
	
	public String update(UpdateData form) {
		return changerepository.update(form);
	}
	
	public Map<Integer,String> moniForm(){
		Map<Integer,String> moni = new LinkedHashMap<Integer,String>();
		int START = 2014;
		LocalDate date = LocalDate.now();
		int nowYear = date.getYear();
		for(int i = START; i<=nowYear; i++) {
			moni.put(i, i + "年");
		}
		return moni;
	}
}
