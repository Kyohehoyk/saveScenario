package com.saveScenario.saveScenario.scenario.Login.LoginService;

import org.springframework.stereotype.Service;

import com.saveScenario.saveScenario.scenario.Login.LoginForm;
import com.saveScenario.saveScenario.scenario.table.Lists.DbDto.UsersDto;

@Service
public interface LoginService {
	UsersDto checkLogin(LoginForm form);

}
