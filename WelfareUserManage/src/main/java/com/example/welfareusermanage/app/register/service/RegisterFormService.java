package com.example.welfareusermanage.app.register.service;

import org.springframework.stereotype.Service;

import com.example.welfareusermanage.app.register.entity.RegisterForm;
import com.example.welfareusermanage.app.register.repository.RegisterFormRepository;

@Service
public class RegisterFormService {
	private RegisterFormRepository rfRepository;
	
	public RegisterFormService(RegisterFormRepository rfRepository) {
		this.rfRepository = rfRepository;
	}
	
	public RegisterFormRepository getrfRepository() {
		return rfRepository;
	}
	
	public void insert(RegisterForm form) {
		getrfRepository().insert(form);
	}
}
