package com.saveScenario.saveScenario.scenario.table.Lists.DbDto;

import lombok.Data;

@Data
public class PassingDatasDto {
	/** id */
	public Integer id;

	/** セッションID */
	public Integer sessionId;

	/** プレイヤー */
	public Integer player;

	/** 通過班 */
	public Integer passing;
}
