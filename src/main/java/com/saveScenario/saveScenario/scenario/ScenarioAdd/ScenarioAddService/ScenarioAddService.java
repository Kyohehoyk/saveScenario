package com.saveScenario.saveScenario.scenario.ScenarioAdd.ScenarioAddService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.saveScenario.saveScenario.scenario.ScenarioAdd.ScenarioAddForm;
import com.saveScenario.saveScenario.scenario.table.Lists.DbDto.SystemInfosDto;

@Service
public interface ScenarioAddService {
	void regist(ScenarioAddForm form);
	List<SystemInfosDto> getSystem();

}
