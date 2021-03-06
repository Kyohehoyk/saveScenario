package com.saveScenario.saveScenario.scenario.ScenarioEdit;

import java.sql.Timestamp;
import java.util.List;

import lombok.Data;

@Data
public class ScenarioEditDto {
	/** id */
	public Integer id;

	/** セッションid */
	public Integer sessionId;

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

	/** 表示制御 */
	public Integer display;

	/** ニックネーム */
	public String nickname;

	/** システム */
	public Integer systemInfo;

	/** システムネーム */
	public String systemName;

	/** 推奨技能 */
	public String recommendedSkill;

	/** 準推奨技能 */
	public String associateRecommendedSkill;

	/** 非推奨技能 */
	public String nonRecommendedSkill;

	/** シナリオの概要 */
	public String summary;

	/** 画像パス */
	public String imagePass;

	/** 参加者 */
	public List<PassingInfo> joinParticipant;

}
