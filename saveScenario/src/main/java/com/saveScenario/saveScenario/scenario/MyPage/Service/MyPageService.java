package com.saveScenario.saveScenario.scenario.MyPage.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.saveScenario.saveScenario.scenario.MyPage.MyPageForm;

@Service
public interface MyPageService {
	List<MyPageForm> getRegistForm(Integer PlayerId);

	List<MyPageForm> getSubscriptionForm(Integer PlayerId, List<MyPageForm> myPageLists, List<MyPageForm> pass);
}
