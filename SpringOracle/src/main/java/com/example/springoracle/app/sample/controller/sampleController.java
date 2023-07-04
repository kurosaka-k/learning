package com.example.springoracle.app.sample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springoracle.app.sample.CareLevelService;

@Controller
@RequestMapping("/")
public class sampleController {
	
	private static final Logger logger = LoggerFactory.getLogger(sampleController.class);
	
	private CareLevelService carelevelservice;
	
	@Autowired
	public sampleController(CareLevelService carelevelservice) {
		this.carelevelservice = carelevelservice;
	}
	
	@RequestMapping("")
	public String init(Model model) {
		logger.info("サンプル画面　初期表示　開始");
		
		model.addAttribute("clList", carelevelservice.readAll());
		
		logger.info("サンプル画面　初期表示　終了");
		return "index";
	}
}
