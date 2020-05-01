package com.saveScenario.saveScenario.scenario.ScenarioAdd;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class ScenarioAddForm {
	/** id */
	public Integer id;

	/** タイトル */
	public String title;

	/** 作者 */
	public String creater;

	/** 参加人数 */
	public String participant;

	/** 想定時間 */
	public String estimatedTime;

	/** 更新時刻 */
	public Timestamp updateTime;

	/** システム */
	public Integer systemInfo;

	/** 登録者 */
	public Integer register;
}
