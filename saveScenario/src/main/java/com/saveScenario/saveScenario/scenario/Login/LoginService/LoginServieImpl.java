package com.saveScenario.saveScenario.scenario.Login.LoginService;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.saveScenario.saveScenario.scenario.Login.LoginForm;
import com.saveScenario.saveScenario.scenario.table.Lists.DbDto.UsersDto;
import com.saveScenario.saveScenario.scenario.table.Lists.service.UsersService;

@Service
public class LoginServieImpl implements LoginService {

	@Inject
	private UsersService usersService;

	public UsersDto checkLogin(LoginForm form) {
		UsersDto user = new UsersDto();
		user.setLoginId(form.getLoginId());
		user.setPassword(form.getPassword());
		return this.usersService.select(user);
	}
}
