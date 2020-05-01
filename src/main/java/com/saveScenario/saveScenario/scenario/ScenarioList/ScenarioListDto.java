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

	/** 更新時刻 */
	public Timestamp updateTime;
}
