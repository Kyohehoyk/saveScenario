package com.saveScenario.saveScenario.scenario.table.Lists.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.saveScenario.saveScenario.scenario.table.Lists.DbDto.ListsDto;

@Service
public interface ListsService {
	List<ListsDto> Select();
	ListsDto Select(String id);
	List<ListsDto> Select(ListsDto form);

	void insert(ListsDto form);
}
