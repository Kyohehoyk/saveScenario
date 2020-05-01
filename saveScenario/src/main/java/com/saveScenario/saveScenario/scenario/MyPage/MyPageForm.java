package com.saveScenario.saveScenario.scenario.MyPage;

import lombok.Data;

@Data
public class MyPageForm {

	/** id */
	public Integer id;

	/** タイトル */
	public String title;

	/** 作者 */
	public String creater;

	/** 登録者 */
	public String register;

	/** シナリオ時間 */
	public String estimatedTime;

	/** 応募人数 */
	public String participant;

	/** システム */
	public String system;
}
