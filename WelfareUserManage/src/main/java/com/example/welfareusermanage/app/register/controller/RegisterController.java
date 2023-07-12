package com.example.welfareusermanage.app.register.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.welfareusermanage.app.register.entity.InsertData;
import com.example.welfareusermanage.app.register.entity.RegisterForm;
import com.example.welfareusermanage.app.register.service.RegisterFormService;
import com.example.welfareusermanage.app.search.controller.SearchController;
import com.example.welfareusermanage.common.service.RegionCityService;
import com.example.welfareusermanage.table.service.CareMgrService;
import com.example.welfareusermanage.table.service.ChargeService;
import com.example.welfareusermanage.table.service.CityService;
import com.example.welfareusermanage.table.service.HomeSerOfficeService;
import com.example.welfareusermanage.table.service.RegionService;
import com.example.welfareusermanage.table.service.WelfareToolService;

@Controller
@RequestMapping("/register")
public class RegisterController {
	private static final Logger logger = LoggerFactory.getLogger(SearchController.class);

	private RegionService regionservice;
	
	private CityService cityservice;
	
	private WelfareToolService welfaretoolservice;
	
	private RegionCityService regioncityservice;
	
	private RegisterFormService registerformservice;
	
	private ChargeService chargeservice;
	
	private HomeSerOfficeService homeserofficeservice;
	
	private CareMgrService caremgrservice;
	
	public RegisterController(RegionService regionservice,
			CityService cityservice,
			WelfareToolService welfaretoolservice,
			RegionCityService regioncityservice,
			RegisterFormService registerformservice,
			ChargeService chargeservice,
			HomeSerOfficeService homeserofficeservice,
			CareMgrService caremgrservice) {
		this.regionservice = regionservice;
		this.cityservice = cityservice;
		this.welfaretoolservice = welfaretoolservice;
		this.regioncityservice = regioncityservice;
		this.registerformservice = registerformservice;
		this.chargeservice = chargeservice;
		this.homeserofficeservice = homeserofficeservice;
		this.caremgrservice = caremgrservice;
	}
	
	@RequestMapping("")
	public String init( Model model) {
		logger.info("新規登録画面　初期表示　開始");
		
		RegisterForm form = new RegisterForm();
		model.addAttribute("form",form);

		model.addAttribute("regionList",regionservice.readAll());
		
		model.addAttribute("cityList",cityservice.readAll());
				
		model.addAttribute("toolList",welfaretoolservice.readAll());
		
		model.addAttribute("chargeList",chargeservice.readAll());
		
		model.addAttribute("officeList", homeserofficeservice.readAll());
		
		model.addAttribute("careMgrList", caremgrservice.readAll());
		
		logger.info("新規登録画面　初期表示　終了");
		return "register";
	}
	
	@RequestMapping(value = "/registerCheck")
	public String check(@Validated @ModelAttribute("form") RegisterForm form,BindingResult result,Model model) {
		logger.info("登録項目　入力チェック　開始"+form);
		
		model.addAttribute("regionList",regionservice.readAll());
		
		model.addAttribute("cityList",cityservice.readAll());
				
		model.addAttribute("toolList",welfaretoolservice.readAll());
		
		model.addAttribute("chargeList",chargeservice.readAll());
		
		model.addAttribute("officeList", homeserofficeservice.readAll());
		
		model.addAttribute("careMgrList", caremgrservice.readAll());
		
		if(result.hasErrors()) {
			return "register";
		}
		
		logger.info("登録項目確認画面　表示　開始"+form);
		
		model.addAttribute("form",registerformservice.convert(form));
		
		model.addAttribute("regioncityList" ,regioncityservice.readAll());
		
		logger.info("登録項目確認画面　表示　終了"+registerformservice.convert(form));
		return "registerCheck";
	}
	
	@RequestMapping("/create")
	public String create(InsertData form,Model model) {
		logger.info("新規登録　処理　開始"+form);
		
		String userId = registerformservice.insert(form);
		
		logger.info("新規登録　処理　終了");
		return "forward:/detailData";
	}
}
