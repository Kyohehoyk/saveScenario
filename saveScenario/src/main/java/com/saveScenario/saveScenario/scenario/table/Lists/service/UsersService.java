package com.saveScenario.saveScenario.scenario.table.Lists.service;

import org.springframework.stereotype.Service;

import com.saveScenario.saveScenario.scenario.table.Lists.DbDto.UsersDto;

@Service
public interface UsersService {
	UsersDto select(UsersDto usersDto);
	String selectNickname(UsersDto usersDto);
	String selectLoginId(UsersDto usersDto);

	void insert(UsersDto usersDto);

}
