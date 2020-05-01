package com.saveScenario.saveScenario.scenario.table.Lists.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.saveScenario.saveScenario.scenario.table.Lists.DbDto.PassingDatasDto;

@Service
public interface PassingDatasService {
	List<PassingDatasDto> select(PassingDatasDto passDto);
	void insert(PassingDatasDto passDto);
	void update(PassingDatasDto passDto);

}
