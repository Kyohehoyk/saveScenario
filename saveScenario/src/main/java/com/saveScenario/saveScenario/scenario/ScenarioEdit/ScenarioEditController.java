package com.saveScenario.saveScenario.scenario.ScenarioEdit;

import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.saveScenario.saveScenario.scenario.ScenarioEdit.ScenarioEditService.ScenarioEditService;
import com.saveScenario.saveScenario.scenario.Util.CopyUtil;

@Controller
public class ScenarioEditController {

	@Inject
	private ScenarioEditService scenarioEditService;

	@RequestMapping(value = "/scenario/scenarioEdit/{sessionId}", method = RequestMethod.GET)
	public String edit(HttpServletRequest req, Locale locale, Model model, @PathVariable("sessionId") String sessionId) {
		ScenarioEditDto scenarioEditDto = new ScenarioEditDto();
		scenarioEditDto.setSessionId(Integer.parseInt(sessionId));
		this.scenarioEditService.init(scenarioEditDto);
		model.addAttribute("ScenarioEditForm", scenarioEditDto);
		return "scenario/scenarioEdit";
	}

	@RequestMapping(value = "/scenario/scenarioEdit/update", method = RequestMethod.POST)
	public String update(HttpServletRequest req, Locale locale, Model model, @Validated ScenarioEditForm inputForm) {
		ScenarioEditDto scenarioEditDto = new ScenarioEditDto();
		CopyUtil.copyProperty(scenarioEditDto, inputForm);
		this.scenarioEditService.update(scenarioEditDto);

		ScenarioEditDto rtnScenarioEditDto = new ScenarioEditDto();
		rtnScenarioEditDto.setSessionId(scenarioEditDto.getSessionId());
		this.scenarioEditService.init(rtnScenarioEditDto);
		model.addAttribute("ScenarioEditForm", rtnScenarioEditDto);
		return "scenario/scenarioEdit";
	}

	@RequestMapping(value = "/scenario/delite/{sessionId}", method = RequestMethod.GET)
	public String delite(HttpServletRequest req, Locale locale, Model model, @PathVariable("sessionId") String sessionId) {
		this.scenarioEditService.delite(Integer.parseInt(sessionId));
		return "redirect:../scenarioList/";
	}

}
