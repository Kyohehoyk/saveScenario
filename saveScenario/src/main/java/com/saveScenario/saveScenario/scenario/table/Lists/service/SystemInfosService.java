package com.saveScenario.saveScenario.scenario.table.Lists.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.saveScenario.saveScenario.scenario.table.Lists.DbDto.SystemInfosDto;

@Service
public interface SystemInfosService {
	List<SystemInfosDto> select(SystemInfosDto dto);
}
