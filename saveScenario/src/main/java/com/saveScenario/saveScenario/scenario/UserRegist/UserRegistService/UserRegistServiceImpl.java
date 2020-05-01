package com.saveScenario.saveScenario.scenario.UserRegist.UserRegistService;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.saveScenario.saveScenario.scenario.UserRegist.UserRegistForm;
import com.saveScenario.saveScenario.scenario.table.Lists.DbDto.UsersDto;
import com.saveScenario.saveScenario.scenario.table.Lists.service.UsersService;

@Service
public class UserRegistServiceImpl implements UserRegistService {
	@Inject
	private UsersService usersService;

	@Override
	public void UserRegist(UserRegistForm form) {
		UsersDto user = new UsersDto();
		user.setLoginId(form.getLoginId());
		user.setNickname(form.getNickname());
		user.setPassword(form.getPassword());

	}


}
