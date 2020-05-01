package com.saveScenario.saveScenario.scenario.table.Lists.DbDto;

import lombok.Data;

/**
 * Usersのテーブル
 */
@Data
public class UsersDto {
	/** id */
	public Integer id;

	/** ログインID */
	public String loginId;

	/** パスワード */
	public String password;

	/** ニックネーム */
	public String nickname;

}
