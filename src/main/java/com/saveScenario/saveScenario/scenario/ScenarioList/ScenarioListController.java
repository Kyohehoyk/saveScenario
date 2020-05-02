package com.saveScenario.saveScenario.scenario.ScenarioList;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.saveScenario.saveScenario.scenario.ScenarioList.ScenarioListService.ScenarioListService;
import com.saveScenario.saveScenario.scenario.Util.CopyUtil;

/**
 * シナリオ情報の一覧画面
 */
@Controller
public class ScenarioListController {
	private final int PAZE_SIZE = 21;
	@Inject
	private ScenarioListService scenarioListService;

	@RequestMapping({"/scenario/scenarioList/{id}"})
	public String list(HttpServletRequest req, Locale locale, Model model, @PathVariable("id") Integer id) {
		List<ScenarioListDto> dto = this.scenarioListService.selectList();
		int lastPage = dto.size() / PAZE_SIZE;
		if (dto.size() % PAZE_SIZE > 0) {
			++lastPage;
		}
		int min = (id - 1) * PAZE_SIZE;
		if (dto.size() < min) {
			int surplus = 0;
			if (dto.size() % PAZE_SIZE > 0) {
				surplus = 1;
			}
			id = dto.size() / PAZE_SIZE + surplus;
			min = (id - 1) * PAZE_SIZE;
		}
		int max = (id - 1) * PAZE_SIZE + PAZE_SIZE;
		if (dto.size() < max) {         max = dto.size();      }
		dto = dto.subList(min, max);
		List<ScenarioListForm> form = new ArrayList<ScenarioListForm>();
		CopyUtil.copyProperties(form, dto, ScenarioListForm.class);

		model.addAttribute("ScenarioListForm", form);

		if (id == 1) {
			model.addAttribute("beforePage", 1);
		} else {
			model.addAttribute("beforePage", id - 1);
		}
		model.addAttribute("nowPage", id);
		if (id == lastPage) {
			model.addAttribute("afterPage", lastPage);
		} else {
			model.addAttribute("afterPage", id + 1);
		}
		model.addAttribute("lastPage", lastPage);
		return "scenario/scenarioList";
	}

	@RequestMapping({"/scenario/scenarioList/"})
	public String list_init(HttpServletRequest req, Locale locale, Model model) {
		List<ScenarioListDto> dto = this.scenarioListService.selectList();

		int lastPage = dto.size() / PAZE_SIZE;
		if (dto.size() % PAZE_SIZE > 0) {
			++lastPage;      }
		int max = PAZE_SIZE;
		if (dto.size() < max) {         max = dto.size();      }
		dto = dto.subList(0, max);
		List<ScenarioListForm> form = new ArrayList<ScenarioListForm>();
		CopyUtil.copyProperties(form, dto, ScenarioListForm.class);

		model.addAttribute("ScenarioListForm", form);
		model.addAttribute("beforePage", 1);
		model.addAttribute("nowPage", 1);
		model.addAttribute("afterPage", 2);
		model.addAttribute("lastPage", lastPage);

		return "scenario/scenarioList";
	}
}
