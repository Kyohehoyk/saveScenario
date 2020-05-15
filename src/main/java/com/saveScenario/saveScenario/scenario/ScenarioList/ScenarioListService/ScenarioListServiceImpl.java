package com.saveScenario.saveScenario.scenario.ScenarioList.ScenarioListService;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.saveScenario.saveScenario.scenario.ScenarioList.ScenarioListDto;
import com.saveScenario.saveScenario.scenario.Util.CopyUtil;
import com.saveScenario.saveScenario.scenario.table.Lists.DbDto.ListsDto;
import com.saveScenario.saveScenario.scenario.table.Lists.DbDto.SystemInfosDto;
import com.saveScenario.saveScenario.scenario.table.Lists.service.ListsService;
import com.saveScenario.saveScenario.scenario.table.Lists.service.SystemInfosService;

@Service
public class ScenarioListServiceImpl implements ScenarioListService{

	@Inject
	private ListsService listsService;

	@Inject
	private SystemInfosService systemInfosService;

	@Override
	public List<ScenarioListDto> selectList() {
		List<ScenarioListDto> dto = new ArrayList<ScenarioListDto>();
		ListsDto cond = new ListsDto();
		cond.setDisplay(1);
		List<ListsDto> list = this.listsService.Select(cond);
		CopyUtil.copyProperties(dto, list, ScenarioListDto.class);

		for(ScenarioListDto System:dto) {
			SystemInfosDto systemInfosDto = new SystemInfosDto();
			systemInfosDto.setId(System.getSystemInfo());
			List<SystemInfosDto> systemInfosDtoList = this.systemInfosService.select(systemInfosDto);
			String SystemName = systemInfosDtoList.get(0).getSystemInfo();
			System.setSystemName(SystemName);
		}

		return dto;
	}

}
