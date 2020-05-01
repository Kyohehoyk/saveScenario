package com.saveScenario.saveScenario.scenario.table.Lists.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.saveScenario.saveScenario.scenario.table.Lists.DbDto.ScenarioInfosDto;

@Service
public interface ScenarioInfosService {
	List<ScenarioInfosDto> select(ScenarioInfosDto dto);
	void insert(ScenarioInfosDto dto);
	void update(ScenarioInfosDto dto);
}
