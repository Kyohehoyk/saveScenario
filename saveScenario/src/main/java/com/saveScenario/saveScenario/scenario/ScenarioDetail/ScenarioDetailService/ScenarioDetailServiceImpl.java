package com.saveScenario.saveScenario.scenario.ScenarioDetail.ScenarioDetailService;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.saveScenario.saveScenario.scenario.ScenarioDetail.ScenarioDetailDto;
import com.saveScenario.saveScenario.scenario.Util.CommonInfoUtil;
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
public class ScenarioDetailServiceImpl implements ScenarioDetailService{

	@Inject
	private ListsService listsService;

	@Inject
	private SystemInfosService systemInfosService;

	@Inject
	private UsersService usersService;

	@Inject
	private ScenarioInfosService scenarioInfosService;

	@Inject
	private PassingDatasService passingDatasService;

	@Override
	public ScenarioDetailDto selectInfo(String id) {
		// シナリオ詳細の基本情報
		ScenarioDetailDto dto = new ScenarioDetailDto();
		ListsDto listsDto = this.listsService.Select(id);
		CopyUtil.copyProperty(dto, listsDto);

		// システムの情報取得
		SystemInfosDto systemInfosDto = new SystemInfosDto();
		systemInfosDto.setId(listsDto.getSystemInfo());
		List<SystemInfosDto> systemInfosDtoList = this.systemInfosService.select(systemInfosDto);
		// 存在しないNoは入らないのでエラーチェックはしない。
		dto.setSystemName(systemInfosDtoList.get(0).getSystemInfo());

		// 登録者の名前取得
		UsersDto rDto = new UsersDto();
		rDto.setId(listsDto.getRegister());
		String rNickname = this.usersService.selectNickname(rDto);
		dto.setRegisterName(rNickname);

		// KP/GMのニックネーム取得
		UsersDto usersDto = new UsersDto();
		usersDto.setId(listsDto.getRegister());
		String nickname = this.usersService.selectNickname(usersDto);
		dto.setNickname(nickname);

		// 推奨技能系統/シナリオ画像/あらすじを取得
		ScenarioInfosDto scenarioInfosDto = new ScenarioInfosDto();
		scenarioInfosDto.setSessionId(listsDto.getId());
		List<ScenarioInfosDto> scenarioInfosDtoList = this.scenarioInfosService.select(scenarioInfosDto);
		for (ScenarioInfosDto siDto : scenarioInfosDtoList) {
			if (listsDto.getSystemInfo()==1) {
				if(CommonInfoUtil.RECOMMENDED_SKILL.equals(siDto.getKind())) {
					dto.setRecommendedSkill(siDto.getContent());
				} else if (CommonInfoUtil.ASSOCIATE_RECOMMENDED_SKILL.equals(siDto.getKind())) {
					dto.setAssociateRecommendedSkill(siDto.getContent());
				} else if (CommonInfoUtil.NON_RECOMMENDED_SKILL.equals(siDto.getKind())) {
					dto.setNonRecommendedSkill(siDto.getContent());
				}
			}else if(CommonInfoUtil.SUMMARY.equals(siDto.getKind())) {
				dto.setSummary(siDto.getContent());
			} else {
				dto.setImagePass(siDto.getContent());
			}
		}

		// 通過者の取得
		PassingDatasDto passingDatasDto = new PassingDatasDto();
		passingDatasDto.setSessionId(listsDto.getId());
		List<PassingDatasDto> passingDatasDtoList = this.passingDatasService.select(passingDatasDto);
		List<String> tmpJoinParticipant = new ArrayList<String>();
		for (PassingDatasDto pdDto : passingDatasDtoList) {
			UsersDto ParticipantName = new UsersDto();
			ParticipantName.setId(pdDto.getPlayer());
			String plNickname = this.usersService.selectNickname(ParticipantName);
			if(pdDto.getPassing() == 0) {
				tmpJoinParticipant.add(plNickname+":参加応募中");
			} else {
				tmpJoinParticipant.add(plNickname+":第"+ pdDto.getPassing() +"班で通過");
			}
		}
		dto.setJoinParticipant(tmpJoinParticipant);

		return dto;
	}

	@Override
	public void insert(Integer sessionId, Integer userId) {
		PassingDatasDto passData = new PassingDatasDto();
		passData.setSessionId(sessionId);
		passData.setPlayer(userId);
		this.passingDatasService.insert(passData);

	}
}
