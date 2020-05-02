package com.saveScenario.saveScenario.scenario.ScenarioAdd.ScenarioAddService;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;

import com.saveScenario.saveScenario.scenario.ScenarioAdd.ScenarioAddForm;
import com.saveScenario.saveScenario.scenario.Util.CommonUtil;
import com.saveScenario.saveScenario.scenario.table.Lists.DbDto.ListsDto;
import com.saveScenario.saveScenario.scenario.table.Lists.service.ListsServiceImpl;

@Service
public class ScenarioAddValidator {
	@Inject
	private ListsServiceImpl listsServiceImpl;

	public String validator(ScenarioAddForm form, Model model, Integer userId) {
		String errMsg = "";
		// タイトルが未入力の場合
		if (form.getTitle().length() == 0) {
			errMsg = errMsg + "タイトルを入力してください。<br>";
		}

		// 同じ人がすでに登録済みのタイトルを入力済の場合
		if (this.checkTitle(form, userId)) {
			errMsg = errMsg + "そのシナリオは登録済みです。<br>";
		}

		// タイトルが未入力の場合
		if (form.getCreater().length() == 0) {
			errMsg = errMsg + "製作者を入力してください。<br>";
		}

		//参加人数のチェック
		if (form.getParticipantStart().length() != 0) {
			if(!CommonUtil.isInteger(form.getParticipantStart())){
				errMsg = errMsg + "参加人数は整数を入力してください。<br>";
			}
		}
		if (form.getParticipantEnd().length() != 0) {
			if(!CommonUtil.isInteger(form.getParticipantEnd())){
				errMsg = errMsg + "参加人数は整数を入力してください。<br>";
			}
		}
		//想定時間のチェック
		if (form.getEstimatedTimeStart().length() != 0) {
			if(!CommonUtil.isFloat(form.getEstimatedTimeStart())){
				errMsg = errMsg + "想定時間は数値を入力してください。<br>";
			}
		}
		if (form.getEstimatedTimeEnd().length() != 0) {
			if(!CommonUtil.isFloat(form.getEstimatedTimeEnd())){
				errMsg = errMsg + "想定時間は数値を入力してください。<br>";
			}
		}
		// システムが未選択の場合
		if (form.getSystemInfo() == 0) {
			errMsg = errMsg + "システムを選択してください。<br>";
		}

		return errMsg;
	}

	private boolean checkTitle(ScenarioAddForm form, Integer userId) {
		ListsDto dto = new ListsDto();
		dto.setRegister(userId);
		dto.setTitle(form.getTitle());
		dto.setSystemInfo(form.getSystemInfo());
		List<ListsDto> dtoList =this.listsServiceImpl.Select(dto);
		if(CollectionUtils.isEmpty(dtoList)) {
			return false;
		}
		return true;
	}

}
