package com.saveScenario.saveScenario.scenario.ScenarioList.ScenarioListService;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.saveScenario.saveScenario.scenario.ScenarioList.ScenarioListDto;
import com.saveScenario.saveScenario.scenario.Util.CopyUtil;
import com.saveScenario.saveScenario.scenario.table.Lists.DbDto.ListsDto;
import com.saveScenario.saveScenario.scenario.table.Lists.service.ListsService;

@Service
public class ScenarioListServiceImpl implements ScenarioListService{

	@Inject
	private ListsService listsService;

	@Override
	public List<ScenarioListDto> selectList() {
		List<ScenarioListDto> dto = new ArrayList<ScenarioListDto>();
		List<ListsDto> list = this.listsService.Select();
		CopyUtil.copyProperties(dto, list, ScenarioListDto.class);

		return dto;
	}

}
