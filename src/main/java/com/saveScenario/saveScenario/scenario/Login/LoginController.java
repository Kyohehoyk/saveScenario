package com.saveScenario.saveScenario.scenario.Login;

import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.saveScenario.saveScenario.scenario.Login.LoginService.LoginValidator;
import com.saveScenario.saveScenario.scenario.Util.CommonInfoUtil;
import com.saveScenario.saveScenario.scenario.Util.CopyUtil;
import com.saveScenario.saveScenario.scenario.table.Lists.DbDto.UsersDto;
import com.saveScenario.saveScenario.scenario.table.Lists.service.UsersService;

/**
 * シナリオ情報追加画面
 */
@Controller
public class LoginController {
	@Inject
	private UsersService usersService;

	@Inject
	private LoginValidator loginValidator;

	/**
	 * シナリオ情報追加の初期画面
	 */
	@RequestMapping(value = "/scenario/login/", method = RequestMethod.GET)
	public String init(HttpServletRequest req, Locale locale, Model model) {
		LoginForm form = new LoginForm();
		model.addAttribute("LoginForm", form);
		return "scenario/login";
	}

	/**
	 * シナリオ情報追加の初期画面
	 */
	@RequestMapping(value = "/scenario/logout/", method = RequestMethod.GET)
	public String logout(HttpServletRequest req, Locale locale, Model model) {
		LoginForm form = new LoginForm();
		model.addAttribute("LoginForm", form);
		HttpSession session = req.getSession();
		session.removeAttribute(CommonInfoUtil.SESSION_NICKNAME);//usersDto.getNickname());
		session.removeAttribute(CommonInfoUtil.SESSION_USERID);
		return "redirect:../login/";
	}

	/**
	 * シナリオ情報追加の情報追加
	 */
	@RequestMapping(value = "/scenario/login/confirm", method = RequestMethod.POST)
	public String subimt(HttpServletRequest req, Locale locale, Model model, @Validated LoginForm inputForm) {
		LoginForm form = new LoginForm();
		UsersDto usersDto = new UsersDto();
		CopyUtil.copyProperty(form, inputForm);
		String errMsg = this.loginValidator.validator(form);
		if (!CommonInfoUtil.BLANK.equals(errMsg)) {
			model.addAttribute("errMsg", errMsg);
			model.addAttribute("LoginForm", form);
			return "scenario/login";
		}
		usersDto.setLoginId(form.getLoginId());
		usersDto.setPassword(form.getPassword());
		usersDto = this.usersService.select(usersDto);
		HttpSession session = req.getSession();
		session.setAttribute(CommonInfoUtil.SESSION_NICKNAME, usersDto.getNickname());
		session.setAttribute(CommonInfoUtil.SESSION_USERID, usersDto.getId());
		model.addAttribute("LoginForm", form);
		return "redirect:../scenarioList/";
	}
}
