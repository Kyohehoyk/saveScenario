package com.saveScenario.saveScenario.scenario.table.Lists.DbDto;

import java.sql.Timestamp;

import lombok.Data;


/**
 * Listsのテーブル
 */
@Data
public class ListsDto {
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

	/** 登録者 */
	public Integer register;

	/**  システム */
	public Integer systemInfo;

	/**  表示設定(1:表示 -1:非表示) */
	public Integer display;
}
