package com.saveScenario.saveScenario.scenario.MyPage.Service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.saveScenario.saveScenario.scenario.MyPage.MyPageForm;
import com.saveScenario.saveScenario.scenario.table.Lists.DbDto.ListsDto;
import com.saveScenario.saveScenario.scenario.table.Lists.DbDto.PassingDatasDto;
import com.saveScenario.saveScenario.scenario.table.Lists.DbDto.SystemInfosDto;
import com.saveScenario.saveScenario.scenario.table.Lists.DbDto.UsersDto;
import com.saveScenario.saveScenario.scenario.table.Lists.service.ListsService;
import com.saveScenario.saveScenario.scenario.table.Lists.service.PassingDatasService;
import com.saveScenario.saveScenario.scenario.table.Lists.service.SystemInfosService;
import com.saveScenario.saveScenario.scenario.table.Lists.service.UsersService;

@Service
public class MyPageServiceImpl implements MyPageService{

	@Inject
	private ListsService listsService;

	@Inject
	private SystemInfosService systemInfosService;

	@Inject
	private PassingDatasService passingDatasService;

	@Inject
	private UsersService usersService;

	public List<MyPageForm> getRegistForm(Integer playerId){
		List<MyPageForm> myPageLists = new ArrayList<MyPageForm>();
		ListsDto list = new ListsDto();
		list.setRegister(playerId);
		List<ListsDto> lists = this.listsService.Select(list);
		if (lists == null) {
			return myPageLists;
		}
		for (ListsDto dto : lists) {
			MyPageForm form = new MyPageForm();
			form.setId(dto.getId());
			form.setTitle(dto.getTitle());
			form.setCreater(dto.getCreater());
			SystemInfosDto systemDto = new SystemInfosDto();
			systemDto.setId(dto.getSystemInfo());
			systemDto = this.systemInfosService.select(systemDto).get(0);
			form.setSystem(systemDto.getSystemInfo());
			myPageLists.add(form);
		}
		return myPageLists;
	}

	public List<MyPageForm> getSubscriptionForm(Integer playerId, List<MyPageForm> subscription, List<MyPageForm> pass){
		PassingDatasDto passDto = new PassingDatasDto();
		passDto.setPlayer(playerId);
		List<PassingDatasDto> passList = this.passingDatasService.select(passDto);
		if (passList == null) {
			return subscription;
		}

		for (PassingDatasDto passTmpDto : passList) {
			ListsDto dto =  this.listsService.Select(String.valueOf(passTmpDto.getSessionId()));
			if (dto == null) {
				continue;
			}
			MyPageForm form = new MyPageForm();
			form.setId(dto.getId());
			form.setTitle(dto.getTitle());
			form.setCreater(dto.getCreater());
			SystemInfosDto systemDto = new SystemInfosDto();
			systemDto.setId(dto.getSystemInfo());
			systemDto = this.systemInfosService.select(systemDto).get(0);
			form.setSystem(systemDto.getSystemInfo());
			if (passTmpDto.getPassing() > 0) {
				pass.add(form);
			} else {
				form.setParticipant(dto.getParticipant());
				UsersDto usersDto = new UsersDto();
				usersDto.setId(dto.getRegister());
				String nickname = this.usersService.selectNickname(usersDto);
				form.setRegister(nickname);
				subscription.add(form);
			}
		}
		return subscription;
	}

}
