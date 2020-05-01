package com.saveScenario.saveScenario.scenario.ScenarioList;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.saveScenario.saveScenario.scenario.ScenarioList.ScenarioListService.ScenarioListService;
import com.saveScenario.saveScenario.scenario.Util.CopyUtil;

/**
 * シナリオ情報の一覧画面
 */
@Controller
public class ScenarioListController {
	private static final Logger logger = LoggerFactory.getLogger(ScenarioListController.class);

	@Inject
	private ScenarioListService scenarioListService;

	/**
	 * シナリオリストの一覧画面
	 */
	@RequestMapping(value = "/scenario/scenarioList/", method = RequestMethod.GET)
	public String list(HttpServletRequest req, Locale locale, Model model) {
		List<ScenarioListDto> dto = this.scenarioListService.selectList();
		List<ScenarioListForm> form = new ArrayList<ScenarioListForm>();
		CopyUtil.copyProperties(form, dto, ScenarioListForm.class);

		model.addAttribute("ScenarioListForm", form);

		return "scenario/scenarioList";
	}
}
