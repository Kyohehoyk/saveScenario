package com.saveScenario.saveScenario.scenario.ScenarioEdit.ScenarioEditService;

import org.springframework.stereotype.Service;

import com.saveScenario.saveScenario.scenario.ScenarioEdit.ScenarioEditDto;

@Service
public interface ScenarioEditService {
	void init(ScenarioEditDto scenarioEditDto);
	void update(ScenarioEditDto scenarioEditDto);
	void delite(Integer sessionId);
	void restoration(Integer sessionId);
}
