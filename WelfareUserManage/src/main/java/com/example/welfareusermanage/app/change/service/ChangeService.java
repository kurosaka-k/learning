package com.example.welfareusermanage.app.change.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.welfareusermanage.app.change.entity.ChangeForm;
import com.example.welfareusermanage.app.change.repository.ChangeRepository;

@Service
public class ChangeService {
	@Autowired
	private ChangeRepository changerepository;
	
	public ChangeForm read(String userId) {
		return changerepository.find(userId);
	}
}
