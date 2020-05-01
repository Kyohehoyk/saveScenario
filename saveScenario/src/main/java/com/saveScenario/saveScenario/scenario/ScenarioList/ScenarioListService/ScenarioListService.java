package com.saveScenario.saveScenario.scenario.ScenarioList.ScenarioListService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.saveScenario.saveScenario.scenario.ScenarioList.ScenarioListDto;

@Service
public interface ScenarioListService {
	List<ScenarioListDto> selectList();

}
