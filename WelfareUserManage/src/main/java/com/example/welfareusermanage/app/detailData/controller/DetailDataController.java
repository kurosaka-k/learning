package com.example.welfareusermanage.app.detailData.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.welfareusermanage.app.detailData.entity.detailDataForm;
import com.example.welfareusermanage.app.search.controller.SearchController;

@Controller
@RequestMapping("detailData")
public class DetailDataController {
	private static final Logger logger = LoggerFactory.getLogger(SearchController.class);

	@RequestMapping("")
	public String init(Model model) {
		logger.info("個人データ詳細画面　初期表示　開始");
		
		detailDataForm form = new detailDataForm();
		model.addAttribute("form",form);
		
		logger.info("個人データ詳細画面　初期表示　終了");
		return "detailData";
	}
}
