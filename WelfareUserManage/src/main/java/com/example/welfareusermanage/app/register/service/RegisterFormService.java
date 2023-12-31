package com.example.welfareusermanage.app.register.service;

import org.springframework.stereotype.Service;

import com.example.welfareusermanage.app.register.entity.InsertData;
import com.example.welfareusermanage.app.register.entity.RegisterCheckForm;
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
	
	public String insert(InsertData form) {
		return getrfRepository().insert(form);
	}
	
	public RegisterCheckForm convert(RegisterForm form) {
		RegisterCheckForm item = new RegisterCheckForm(form);
		return item;
	}
}
