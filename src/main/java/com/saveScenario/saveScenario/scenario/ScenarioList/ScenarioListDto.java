package com.saveScenario.saveScenario.scenario.ScenarioList;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class ScenarioListDto {
	/** id */
	public Integer id;

	/** タイトル */
	public String title;

	/** 作者 */
	public String creater;

	/** システム名 */
	public String systemName;

	/** システム情報 */
	public Integer systemInfo;

	/** 参加人数 */
	public String participant;

	/** 想定時間 */
	public String estimatedTime;

	/** 更新時刻 */
	public Timestamp updateTime;
}
