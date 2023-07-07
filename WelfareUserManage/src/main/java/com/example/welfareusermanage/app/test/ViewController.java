package com.example.welfareusermanage.app.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.welfareusermanage.table.service.RegionService;

@Controller
@RequestMapping("/")
public class ViewController {
	private static final Logger logger = LoggerFactory.getLogger(ViewController.class);

	private RegionService regionservice;

	@Autowired
	public ViewController(RegionService regionservice) {
		this.regionservice = regionservice;
	}

	@RequestMapping("/")
	public String init(Model model) {
		logger.info("開始");
		
		model.addAttribute("regionList",regionservice.readAll());
		
		logger.info("終了");
		
		return "view";
	}
}
