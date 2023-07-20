package com.example.welfareusermanage.app.change.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.welfareusermanage.app.change.entity.ChangeForm;
import com.example.welfareusermanage.app.change.entity.UpdateData;
import com.example.welfareusermanage.app.change.service.ChangeService;
import com.example.welfareusermanage.app.search.controller.SearchController;
import com.example.welfareusermanage.common.service.RegionCityService;
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
	@Autowired
	private RegionCityService regioncityservice;
	
	@RequestMapping("/{userId}")
	public String init(@PathVariable String userId,Model model) {
		logger.info("更新画面　初期表示　開始");
		
		ChangeForm changeForm = changeservice.read(userId);
		String[] toolArry = changeForm.getTools().split(",");
		List<String> userTool = new ArrayList<String>(Arrays.asList(toolArry));

		model.addAttribute("userTool",userTool);
		
		model.addAttribute("yearList",changeservice.moniForm());
		
		model.addAttribute("regionList",regionservice.readAll());
		
		model.addAttribute("cityList",cityservice.readAll());
				
		model.addAttribute("toolList",welfaretoolservice.readAll());		
		
		model.addAttribute("chargeList",chargeservice.readAll());
		
		model.addAttribute("officeList", homeserofficeservice.readAll());
		
		model.addAttribute("careMgrList", caremgrservice.readAll());
		
		model.addAttribute("form",changeForm);
		
		logger.info("更新画面　初期表示　終了"+changeservice.read(userId));
		return "change";
	}
	
	@RequestMapping("/changeCheck")
	public String check(@Validated @ModelAttribute("form")ChangeForm form,BindingResult result, Model model) {
		logger.info("更新画面　入力チェック　開始");

		model.addAttribute("yearList",changeservice.moniForm());
		
		model.addAttribute("regionList",regionservice.readAll());
		
		model.addAttribute("cityList",cityservice.readAll());
				
		model.addAttribute("toolList",welfaretoolservice.readAll());
		
		model.addAttribute("chargeList",chargeservice.readAll());
		
		model.addAttribute("officeList", homeserofficeservice.readAll());
		
		model.addAttribute("careMgrList", caremgrservice.readAll());
		
		if(result.hasErrors()) {
			return "change";
		}
		
		logger.info("更新画面　入力チェック　終了"+form);
		
		logger.info("更新項目確認画面　初期表示　開始");
		
		model.addAttribute("regioncityList",regioncityservice.readAll());
		
		model.addAttribute("form",changeservice.convert(form));
		
		logger.info("更新項目確認画面　初期表示　終了"+changeservice.convert(form));
		return "changeCheck";
	}
	
	@RequestMapping("/update")
	public String update(UpdateData form, Model model) {
		logger.info("更新　処理　開始"+form);
		
		changeservice.update(form);
		
		logger.info("更新　処理　終了");
		return "forward:/detailData/"+form.getUserId() ;
	}
}
