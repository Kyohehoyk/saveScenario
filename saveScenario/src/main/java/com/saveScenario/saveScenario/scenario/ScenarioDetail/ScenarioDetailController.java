package com.saveScenario.saveScenario.scenario.ScenarioDetail;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.saveScenario.saveScenario.scenario.ScenarioDetail.ScenarioDetailService.ScenarioDetailService;
import com.saveScenario.saveScenario.scenario.Util.CommonInfoUtil;
import com.saveScenario.saveScenario.scenario.Util.CopyUtil;
import com.saveScenario.saveScenario.scenario.table.Lists.DbDto.PassingDatasDto;
import com.saveScenario.saveScenario.scenario.table.Lists.service.PassingDatasService;

/**
 * シナリオ情報追加画面
 */
@Controller
public class ScenarioDetailController {
	@Inject
	private ScenarioDetailService scenarioDetailService;

	@Inject
	private PassingDatasService passingDatasService;

	/**
	 * シナリオ情報追加の初期画面
	 */
	@RequestMapping(value = "/scenario/scenarioDetail/{id}", method = RequestMethod.GET)
	public String init(HttpServletRequest req, Locale locale, Model model, @PathVariable("id") String id) {
		ScenarioDetailDto dto = this.scenarioDetailService.selectInfo(id);
		ScenarioDetailForm form = new ScenarioDetailForm();
		CopyUtil.copyProperty(form, dto);
		form.setSessionId(Integer.parseInt(id));
		model.addAttribute("ScenarioDetailForm", form);
		HttpSession session = req.getSession();
		Integer userId = (Integer) session.getAttribute(CommonInfoUtil.SESSION_USERID);
		model.addAttribute("userId", userId);

		return "scenario/scenarioDetail";
	}

	@RequestMapping(value = "/scenario/request/{id}", method = RequestMethod.POST)
	public String request(HttpServletRequest req, Locale locale, Model model, @PathVariable("id") String id) {
		HttpSession session = req.getSession();
		Integer userId = (Integer) session.getAttribute(CommonInfoUtil.SESSION_USERID);

		PassingDatasDto pass = new PassingDatasDto();
		pass.setSessionId(Integer.parseInt(id));
		pass.setPlayer(userId);
		List<PassingDatasDto> subList = this.passingDatasService.select(pass);

		if (userId == null) {
			model.addAttribute("errMsg", "ログインしてください。");
		} else {
			if (subList.size()>0) {
				model.addAttribute("errMsg", "応募済、または通過済です。");
			} else {
				this.scenarioDetailService.insert(Integer.parseInt(id), userId);

			}
		}

		ScenarioDetailDto dto = this.scenarioDetailService.selectInfo(id);
		ScenarioDetailForm form = new ScenarioDetailForm();
		CopyUtil.copyProperty(form, dto);
		form.setSessionId(Integer.parseInt(id));
		model.addAttribute("ScenarioDetailForm", form);
		model.addAttribute("userId", userId);

		return "scenario/scenarioDetail";
	}
}
