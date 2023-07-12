package com.example.welfareusermanage.app.detailData.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.welfareusermanage.app.detailData.service.DetailDataService;
import com.example.welfareusermanage.app.search.controller.SearchController;

@Controller
@RequestMapping("detailData")
public class DetailDataController {
	private static final Logger logger = LoggerFactory.getLogger(SearchController.class);
	@Autowired
	private DetailDataService detaildataservice;
	
	
	@RequestMapping("/{userId}")
	public String init(@PathVariable String userId, Model model) {
		logger.info("個人データ詳細画面　初期表示　開始"+userId);
		
		model.addAttribute("form",detaildataservice.read(userId));
		
		logger.info("個人データ詳細画面　初期表示　終了"+detaildataservice.read(userId));
		return "detailData";
	}
}
