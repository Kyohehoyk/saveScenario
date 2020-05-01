package com.saveScenario.saveScenario.scenario.UserRegist.UserRegistService;

import org.springframework.stereotype.Service;

import com.saveScenario.saveScenario.scenario.UserRegist.UserRegistForm;

@Service
public interface UserRegistService {
	void UserRegist(UserRegistForm form);
}
