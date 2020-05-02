package com.saveScenario.saveScenario.scenario.UserRegist;

import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.saveScenario.saveScenario.scenario.UserRegist.UserRegistService.UserRegistValidator;
import com.saveScenario.saveScenario.scenario.table.Lists.DbDto.UsersDto;
import com.saveScenario.saveScenario.scenario.table.Lists.service.UsersService;

@Controller
public class UserRegistController {

	@Inject
	private UserRegistValidator userRegistValidator;

	@Inject
	private UsersService usersService;
	/**
	 * シナリオ情報追加の初期画面
	 */
	@RequestMapping(value = "/scenario/userregist/", method = RequestMethod.GET)
	public String init(HttpServletRequest req, Locale locale, Model model) {
		UserRegistForm form = new UserRegistForm();
		model.addAttribute("UserRegistForm", form);
		return "scenario/userRegist";
	}

	@RequestMapping(value = "/scenario/userregist/regist", method = RequestMethod.POST)
	public String regist(HttpServletRequest req, Locale locale, Model model, @Validated UserRegistForm form) {
		String errMsg = this.userRegistValidator.validator(form);
		if(errMsg.length()!=0) {
			model.addAttribute("errMsg", errMsg);
			model.addAttribute("UserRegistForm", form);
			return "scenario/userRegist";
		}
		UsersDto user = new UsersDto();
		user.setLoginId(form.getLoginId());
		user.setNickname(form.getNickname());
		user.setPassword(form.getPassword());
		this.usersService.insert(user);
		return "redirect:../login/";
	}

}
