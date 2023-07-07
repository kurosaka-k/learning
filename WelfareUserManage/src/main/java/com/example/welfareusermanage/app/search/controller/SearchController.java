package com.example.welfareusermanage.app.search.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.welfareusermanage.app.search.entity.searchForm;
import com.example.welfareusermanage.app.search.service.SearchResultService;
import com.example.welfareusermanage.common.service.CityService;
import com.example.welfareusermanage.common.service.RegionService;
import com.example.welfareusermanage.common.service.WelfareToolService;

@Controller
@RequestMapping("/search")
public class SearchController {
	
	private static final Logger logger = LoggerFactory.getLogger(SearchController.class);

	private RegionService regionservice;
	
	private CityService cityservice;
	
	private WelfareToolService welfaretoolservice;
	
	private SearchResultService searchresultservice;
	
	public SearchController(RegionService regionservice,
			CityService cityservice,WelfareToolService welfaretoolservice,
			SearchResultService searchresultservice) {
		this.regionservice = regionservice;
		this.cityservice = cityservice;
		this.welfaretoolservice = welfaretoolservice;
		this.searchresultservice = searchresultservice;
	}
	
	@RequestMapping("")
	public String init(Model model) {
		logger.info("検索画面　初期表示　開始");
	
		searchForm form = new searchForm();
		model.addAttribute("form",form);

		model.addAttribute("regionList",regionservice.readAll());
		
		model.addAttribute("cityList",cityservice.readAll());
		
		model.addAttribute("toolList",welfaretoolservice.readAll());
		
		logger.info("検索画面　初期表示　終了");
		return "search";
	}
	
	@RequestMapping("/searching")
	public String search(@Validated @ModelAttribute("form") searchForm searchform, Model model) {
		logger.info("検索画面　検索処理　開始");
		
		model.addAttribute("resultList",searchresultservice.search(searchform));
		
		model.addAttribute("regionList",regionservice.readAll());
		
		model.addAttribute("cityList",cityservice.readAll());
		
		model.addAttribute("toolList",welfaretoolservice.readAll());
		
		logger.info("検索画面　検索処理　終了");
		return "search";
	}

}
