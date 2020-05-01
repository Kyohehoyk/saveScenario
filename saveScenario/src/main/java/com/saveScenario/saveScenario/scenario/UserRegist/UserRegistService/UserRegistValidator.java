package com.saveScenario.saveScenario.scenario.UserRegist.UserRegistService;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.saveScenario.saveScenario.scenario.UserRegist.UserRegistForm;
import com.saveScenario.saveScenario.scenario.Util.CommonUtil;
import com.saveScenario.saveScenario.scenario.table.Lists.DbDto.UsersDto;
import com.saveScenario.saveScenario.scenario.table.Lists.service.UsersService;

@Service
public class UserRegistValidator {

	@Inject
	private UsersService usersService;

	public String validator(UserRegistForm form) {
		String errMsg = "";
		UsersDto user = new UsersDto();
		user.setLoginId(form.getLoginId());
		if (CommonUtil.isNullOrEmpty(form.getLoginId())||CommonUtil.isNullOrEmpty(form.getNickname())||CommonUtil.isNullOrEmpty(form.getPassword())||CommonUtil.isNullOrEmpty(form.getConfirmPassword())) {
			errMsg = "未入力の項目があります。";
		} else {
			if ( this.usersService.selectLoginId(user)!=null) {
				errMsg = errMsg + "すでにそのIDは使用されています。</br>";
			}
			if (form.getPassword().trim().length()<8) {
				errMsg = errMsg + "パスワードが短すぎます。８文字以上にしてください。</br>";
			}
			if (!form.getPassword().equals(form.getConfirmPassword())) {
				errMsg = errMsg + "パスワードと確認用パスワード一致しません。</br>";
			}
		}
		return errMsg;
	}
}
