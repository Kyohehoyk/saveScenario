package com.saveScenario.saveScenario.scenario.Login.LoginService;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.saveScenario.saveScenario.scenario.Login.LoginForm;
import com.saveScenario.saveScenario.scenario.table.Lists.DbDto.UsersDto;

@Service
public class LoginValidator {

	@Inject
	private LoginService loginService;

	public String validator(LoginForm form) {
		String errMsg = "";
		UsersDto user = this.loginService.checkLogin(form);
		if (user.getNickname()==null) {
			errMsg = "IDまたはパスワードが間違っています。</br>";
		}
		return errMsg;
	}
}
