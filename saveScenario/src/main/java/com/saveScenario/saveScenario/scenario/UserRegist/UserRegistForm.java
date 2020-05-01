package com.saveScenario.saveScenario.scenario.UserRegist;

import lombok.Data;

@Data
public class UserRegistForm {

	/** ログインID */
	public String loginId;

	/** ニックネーム */
	public String nickname;

	/** パスワード */
	public String password;

	/** 確認用パスワード */
	public String confirmPassword;
}
