package com.example.welfareusermanage.app.search.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.welfareusermanage.app.search.entity.searchForm;
import com.example.welfareusermanage.common.service.CityService;
import com.example.welfareusermanage.common.service.RegionService;

@Controller
@RequestMapping("/search")
public class searchController {
	
	private static final Logger logger = LoggerFactory.getLogger(searchController.class);

	private RegionService regionservice;
	
	private CityService cityservice;
	
	public searchController(RegionService regionservice,CityService cityservice) {
		this.regionservice = regionservice;
		this.cityservice = cityservice;
	}
	
	@RequestMapping("")
	public String init(Model model) {
		logger.info("検索画面　初期表示　開始");
	
		searchForm form = new searchForm();
		model.addAttribute("form",form);

		model.addAttribute("regionList",regionservice.readAll());
		
		model.addAttribute("cityList",cityservice.readAll());
		
		logger.info("検索画面　初期表示　終了");
		return "search";
	}
	
	@RequestMapping("/searching")
	public String search(@Validated @ModelAttribute("form") searchForm searchform, Model model) {
		logger.info("検索画面　初期表示　開始"+searchform);

		model.addAttribute("regionList",regionservice.readAll());
		
		model.addAttribute("cityList",cityservice.readAll());
		
		logger.info("検索画面　初期表示　終了");
		return "search";
	}

}
