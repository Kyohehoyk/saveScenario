package com.saveScenario.saveScenario.scenario.ScenarioAdd.ScenarioAddService;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.saveScenario.saveScenario.scenario.ScenarioAdd.ScenarioAddForm;
import com.saveScenario.saveScenario.scenario.Util.CopyUtil;
import com.saveScenario.saveScenario.scenario.table.Lists.DbDto.ListsDto;
import com.saveScenario.saveScenario.scenario.table.Lists.DbDto.SystemInfosDto;
import com.saveScenario.saveScenario.scenario.table.Lists.service.ListsService;
import com.saveScenario.saveScenario.scenario.table.Lists.service.SystemInfosService;

@Service
public class ScenarioAddServiceImpl implements ScenarioAddService{

	/** Listsのサービスクラス */
	@Inject
	private ListsService listsService;

	/** systemInfosのサービスクラス */
	@Inject
	private SystemInfosService SystemInfosService;

	@Override
	public void regist(ScenarioAddForm form) {
		ListsDto ListsDto = new ListsDto();
		CopyUtil.copyProperty(ListsDto, form);
		this.listsService.insert(ListsDto);

	}

	@Override
	public List<SystemInfosDto> getSystem() {
		return SystemInfosService.select(null);
	}

}
