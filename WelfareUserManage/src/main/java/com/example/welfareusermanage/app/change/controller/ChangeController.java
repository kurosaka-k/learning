package com.example.welfareusermanage.app.change.controller;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.welfareusermanage.app.change.entity.ChangeForm;
import com.example.welfareusermanage.app.change.service.ChangeService;
import com.example.welfareusermanage.app.search.controller.SearchController;
import com.example.welfareusermanage.table.entity.WelfareToolMst;
import com.example.welfareusermanage.table.service.CareMgrService;
import com.example.welfareusermanage.table.service.ChargeService;
import com.example.welfareusermanage.table.service.CityService;
import com.example.welfareusermanage.table.service.HomeSerOfficeService;
import com.example.welfareusermanage.table.service.RegionService;
import com.example.welfareusermanage.table.service.WelfareToolService;

@Controller
@RequestMapping("/change")
public class ChangeController {
	private static final Logger logger = LoggerFactory.getLogger(SearchController.class);
	
	@Autowired
	private RegionService regionservice;
	@Autowired
	private CityService cityservice;
	@Autowired
	private WelfareToolService welfaretoolservice;
	@Autowired
	private ChargeService chargeservice;
	@Autowired
	private HomeSerOfficeService homeserofficeservice;
	@Autowired
	private CareMgrService caremgrservice;
	@Autowired
	private ChangeService changeservice;
	
	@RequestMapping("/{userId}")
	public String init(@PathVariable String userId,Model model) {
		logger.info("更新画面　初期表示　開始");
		
		Map<Integer,String> moni = new LinkedHashMap<Integer,String>();
		int START = 2014;
		LocalDate date = LocalDate.now();
		int nowYear = date.getYear();
		for(int i = START; i<=nowYear; i++) {
			moni.put(i, i + "年");
		}
		List<WelfareToolMst> tools = welfaretoolservice.readAll();
		ChangeForm changeForm = changeservice.read(userId);
		
		
		model.addAttribute("yearList",moni);
		
		model.addAttribute("regionList",regionservice.readAll());
		
		model.addAttribute("cityList",cityservice.readAll());
				
		model.addAttribute("toolList",welfaretoolservice.readAll());
		
		model.addAttribute("chargeList",chargeservice.readAll());
		
		model.addAttribute("officeList", homeserofficeservice.readAll());
		
		model.addAttribute("careMgrList", caremgrservice.readAll());
		
		model.addAttribute("form",changeservice.read(userId));
		
		logger.info("更新画面　初期表示　開始"+changeservice.read(userId));
		return "change";
	}
}
