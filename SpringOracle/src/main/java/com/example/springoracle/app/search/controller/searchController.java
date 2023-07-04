package com.example.springoracle.app.search.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springoracle.app.sample.controller.sampleController;
import com.example.springoracle.app.search.entity.searchForm;

@Controller
@RequestMapping("/search")
public class searchController {
	
	private static final Logger logger = LoggerFactory.getLogger(sampleController.class);
	
	@RequestMapping("")
	public String init(Model model) {
		logger.info("検索画面　初期表示　開始");
		
		searchForm form = new searchForm();
		model.addAttribute("form",form);
		
		logger.info("検索画面　初期表示　終了");
		return "search";
	}
}
