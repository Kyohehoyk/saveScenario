package com.saveScenario.saveScenario.scenario.ScenarioDetail.ScenarioDetailService;

import org.springframework.stereotype.Service;

import com.saveScenario.saveScenario.scenario.ScenarioDetail.ScenarioDetailDto;

@Service
public interface ScenarioDetailService {
	ScenarioDetailDto selectInfo(String id);
	void insert(Integer sessionId, Integer userId);

}
