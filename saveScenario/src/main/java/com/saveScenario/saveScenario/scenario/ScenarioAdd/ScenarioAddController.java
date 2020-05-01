package com.saveScenario.saveScenario.scenario.ScenarioAdd;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.saveScenario.saveScenario.scenario.ScenarioAdd.ScenarioAddService.ScenarioAddService;
import com.saveScenario.saveScenario.scenario.ScenarioAdd.ScenarioAddService.ScenarioAddValidator;
import com.saveScenario.saveScenario.scenario.Util.CommonInfoUtil;
import com.saveScenario.saveScenario.scenario.Util.CopyUtil;
import com.saveScenario.saveScenario.scenario.table.Lists.DbDto.SystemInfosDto;

/**
 * シナリオ情報追加画面
 */
@Controller
public class ScenarioAddController {
	@Inject
	private ScenarioAddService scenarioAddService;
	@Inject
	private ScenarioAddValidator scenarioAddValidator;

	/**
	 * シナリオ情報追加の初期画面
	 */
	@RequestMapping(value = "/scenario/scenarioAdd/", method = RequestMethod.GET)
	public String init(HttpServletRequest req, Locale locale, Model model) {
		ScenarioAddForm form = new ScenarioAddForm();
		List<SystemInfosDto> system =  this.scenarioAddService.getSystem();
		HttpSession session = req.getSession();
		model.addAttribute("nickname",session.getAttribute(CommonInfoUtil.SESSION_NICKNAME));
		model.addAttribute("ScenarioLAddForm", form);
		model.addAttribute("System", system);
		return "scenario/scenarioAdd";
	}

	/**
	 * シナリオ情報追加の情報追加
	 */
	@RequestMapping(value = "/scenario/scenarioAdd/regist", method = RequestMethod.POST)
	public String subimt(HttpServletRequest req, Locale locale, Model model, @Validated ScenarioAddForm inputForm) {
		ScenarioAddForm form = new ScenarioAddForm();
		CopyUtil.copyProperty(form, inputForm);
		HttpSession session = req.getSession();
		Integer userId = (Integer) session.getAttribute(CommonInfoUtil.SESSION_USERID);
		String errMsg = this.scenarioAddValidator.validator(form, model, userId);
		if(errMsg.length()!=0) {
			model.addAttribute("errMsg", errMsg);
		} else {
			form.setRegister(userId);
			this.scenarioAddService.regist(form);
		}
		form = new ScenarioAddForm();
		List<SystemInfosDto> system =  this.scenarioAddService.getSystem();
		model.addAttribute("ScenarioLAddForm", form);
		model.addAttribute("System", system);
		return "scenario/scenarioAdd";
	}
}
