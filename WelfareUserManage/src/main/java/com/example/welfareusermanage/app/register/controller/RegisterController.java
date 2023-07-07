package com.example.welfareusermanage.app.register.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.welfareusermanage.app.register.entity.RegisterForm;
import com.example.welfareusermanage.app.search.controller.SearchController;
import com.example.welfareusermanage.app.search.service.SearchResultService;
import com.example.welfareusermanage.common.service.CityService;
import com.example.welfareusermanage.common.service.RegionService;
import com.example.welfareusermanage.common.service.WelfareToolService;

@Controller
@RequestMapping("/register")
public class RegisterController {
	private static final Logger logger = LoggerFactory.getLogger(SearchController.class);

	private RegionService regionservice;
	
	private CityService cityservice;
	
	private WelfareToolService welfaretoolservice;
	
	private SearchResultService searchresultservice;
	
	public RegisterController(RegionService regionservice,
			CityService cityservice,WelfareToolService welfaretoolservice,
			SearchResultService searchresultservice) {
		this.regionservice = regionservice;
		this.cityservice = cityservice;
		this.welfaretoolservice = welfaretoolservice;
		this.searchresultservice = searchresultservice;
	}
	@RequestMapping("")
	public String init(Model model) {
		logger.info("新規登録画面　初期表示　開始");
		
		RegisterForm form = new RegisterForm();
		model.addAttribute("form",form);

		model.addAttribute("regionList",regionservice.readAll());
		
		model.addAttribute("cityList",cityservice.readAll());
		
		model.addAttribute("toolList",welfaretoolservice.readAll());
		
		logger.info("新規登録画面　初期表示　終了");
		return "register";
	}
}
