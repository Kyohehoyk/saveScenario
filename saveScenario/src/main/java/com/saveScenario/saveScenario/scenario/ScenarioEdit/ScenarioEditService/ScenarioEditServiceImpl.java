package com.saveScenario.saveScenario.scenario.ScenarioEdit.ScenarioEditService;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.saveScenario.saveScenario.scenario.ScenarioEdit.PassingInfo;
import com.saveScenario.saveScenario.scenario.ScenarioEdit.ScenarioEditDto;
import com.saveScenario.saveScenario.scenario.Util.CommonInfoUtil;
import com.saveScenario.saveScenario.scenario.Util.CommonUtil;
import com.saveScenario.saveScenario.scenario.Util.CopyUtil;
import com.saveScenario.saveScenario.scenario.table.Lists.DbDto.ListsDto;
import com.saveScenario.saveScenario.scenario.table.Lists.DbDto.PassingDatasDto;
import com.saveScenario.saveScenario.scenario.table.Lists.DbDto.ScenarioInfosDto;
import com.saveScenario.saveScenario.scenario.table.Lists.DbDto.SystemInfosDto;
import com.saveScenario.saveScenario.scenario.table.Lists.DbDto.UsersDto;
import com.saveScenario.saveScenario.scenario.table.Lists.service.ListsService;
import com.saveScenario.saveScenario.scenario.table.Lists.service.PassingDatasService;
import com.saveScenario.saveScenario.scenario.table.Lists.service.ScenarioInfosService;
import com.saveScenario.saveScenario.scenario.table.Lists.service.SystemInfosService;
import com.saveScenario.saveScenario.scenario.table.Lists.service.UsersService;

@Service
public class ScenarioEditServiceImpl implements ScenarioEditService {

	@Inject
	private ScenarioInfosService scenarioInfosService;

	@Inject
	private SystemInfosService systemInfosService;

	@Inject
	private ListsService listsService;

	@Inject
	private PassingDatasService passingDatasService;

	@Inject
	private UsersService usersService;

	@Override
	public void init(ScenarioEditDto scenarioEditDto) {
		// シナリオ検索
		ListsDto listsDto = this.listsService.Select(String.valueOf(scenarioEditDto.getSessionId()));
		CopyUtil.copyProperty(scenarioEditDto, listsDto);

		//シナリオシステム検索
		SystemInfosDto setSystemInfosDto = new SystemInfosDto();
		setSystemInfosDto.setId(scenarioEditDto.getSystemInfo());
		List<SystemInfosDto> systemInfo = this.systemInfosService.select(setSystemInfosDto);
		scenarioEditDto.setSystemName(systemInfo.get(0).getSystemInfo());

		// シナリオ情報データ検索
		ScenarioInfosDto scenarioInfosDto = new ScenarioInfosDto();
		scenarioInfosDto.setSessionId(scenarioEditDto.getSessionId());
		List<ScenarioInfosDto> scenarioInfosList = this.scenarioInfosService.select(scenarioInfosDto);
		CopyUtil.copyProperty(scenarioInfosList, scenarioEditDto);
		// 値を設定
		for (ScenarioInfosDto siDto : scenarioInfosList) {
			if (scenarioEditDto.getSystemInfo()==1) {
				if(CommonInfoUtil.RECOMMENDED_SKILL.equals(siDto.getKind())) {
					scenarioEditDto.setRecommendedSkill(siDto.getContent());
				} else if (CommonInfoUtil.ASSOCIATE_RECOMMENDED_SKILL.equals(siDto.getKind())) {
					scenarioEditDto.setAssociateRecommendedSkill(siDto.getContent());
				} else if (CommonInfoUtil.NON_RECOMMENDED_SKILL.equals(siDto.getKind())) {
					scenarioEditDto.setNonRecommendedSkill(siDto.getContent());
				}
			}
			if(CommonInfoUtil.SUMMARY.equals(siDto.getKind())) {
				scenarioEditDto.setSummary(siDto.getContent());
			} else if (CommonInfoUtil.IMAGE_PASS.equals(siDto.getKind())) {
				scenarioEditDto.setImagePass(siDto.getContent());
			}
		}

		// 通過者の情報
		List<PassingInfo> passingInfo =new ArrayList<PassingInfo>();
		PassingDatasDto setPassingDatasDto = new PassingDatasDto();
		setPassingDatasDto.setSessionId(scenarioEditDto.getSessionId());
		List<PassingDatasDto> passingDatasDto = this.passingDatasService.select(setPassingDatasDto);
		Integer count=0;
		for (PassingDatasDto pdDto : passingDatasDto) {
			PassingInfo listPassingInfo = new PassingInfo();
			UsersDto usersDto = new UsersDto();
			listPassingInfo.setId(pdDto.getId());
			usersDto.setId(pdDto.getPlayer());
			String nickname = this.usersService.selectNickname(usersDto);
			listPassingInfo.setNo(count);
			listPassingInfo.setNickname(nickname);
			listPassingInfo.setPassing(pdDto.getPassing());
			passingInfo.add(listPassingInfo);
			count++;
		}
		scenarioEditDto.setJoinParticipant(passingInfo);
	}

	@Override
	public void update(ScenarioEditDto scenarioEditDto) {
		// シナリオ情報データ更新
		this.insertOrUpdateScenarioInfos(CommonInfoUtil.RECOMMENDED_SKILL, scenarioEditDto.getRecommendedSkill(), scenarioEditDto.getSessionId());
		this.insertOrUpdateScenarioInfos(CommonInfoUtil.ASSOCIATE_RECOMMENDED_SKILL, scenarioEditDto.getAssociateRecommendedSkill(), scenarioEditDto.getSessionId());
		this.insertOrUpdateScenarioInfos(CommonInfoUtil.NON_RECOMMENDED_SKILL, scenarioEditDto.getNonRecommendedSkill(), scenarioEditDto.getSessionId());
		this.insertOrUpdateScenarioInfos(CommonInfoUtil.SUMMARY, scenarioEditDto.getSummary(), scenarioEditDto.getSessionId());
		this.insertOrUpdateScenarioInfos(CommonInfoUtil.IMAGE_PASS, scenarioEditDto.getImagePass(), scenarioEditDto.getSessionId());
		if (scenarioEditDto.getJoinParticipant() == null || scenarioEditDto.getJoinParticipant().size() <1) {
			return;
		}
		// 通過者更新
		for (PassingInfo pdDto : scenarioEditDto.getJoinParticipant()) {
			PassingDatasDto passDto = new PassingDatasDto();
			passDto.setId(pdDto.getId());
			passDto.setPassing(pdDto.getPassing());
			this.passingDatasService.update(passDto);
		}
	}

	public void insertOrUpdateScenarioInfos(String kind, String content, Integer sessionId) {
		if (CommonUtil.isNullOrEmpty(content)) {
			return;
		}
		// シナリオ情報データ検索
		ScenarioInfosDto keyScenarioInfosDto = new ScenarioInfosDto();
		keyScenarioInfosDto.setSessionId(sessionId);
		keyScenarioInfosDto.setKind(kind);
		List<ScenarioInfosDto> select = this.scenarioInfosService.select(keyScenarioInfosDto);
		keyScenarioInfosDto.setContent(content);
		if (CollectionUtils.isEmpty(select)) {
			this.scenarioInfosService.insert(keyScenarioInfosDto);
		} else {
			this.scenarioInfosService.updateContent(keyScenarioInfosDto);
		}
	}

	public void delite(Integer sessionId) {

	}
}
