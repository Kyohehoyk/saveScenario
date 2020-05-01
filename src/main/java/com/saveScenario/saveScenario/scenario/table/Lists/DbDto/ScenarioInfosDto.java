package com.saveScenario.saveScenario.scenario.table.Lists.DbDto;

import lombok.Data;

@Data
public class ScenarioInfosDto {
	/** id */
	public Integer id;

	/** セッションID */
	public Integer sessionId;

	/** 種類 */
	public String kind;

	/** 情報 */
	public String content;
}
