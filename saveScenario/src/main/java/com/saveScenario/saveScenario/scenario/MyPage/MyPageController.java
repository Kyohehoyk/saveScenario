package com.saveScenario.saveScenario.scenario.MyPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.saveScenario.saveScenario.scenario.MyPage.Service.MyPageService;
import com.saveScenario.saveScenario.scenario.Util.CommonInfoUtil;

@Controller
public class MyPageController {

	@Inject
	private MyPageService myPageService;

	@RequestMapping(value = "/scenario/mypage/", method = RequestMethod.GET)
	public String init(HttpServletRequest req, Locale locale, Model model) {
		HttpSession session = req.getSession();
		Integer userId = (Integer) session.getAttribute(CommonInfoUtil.SESSION_USERID);
		if (userId==null) {
			return "redirect:../login/";
		}
		List<MyPageForm> registForm = this.myPageService.getRegistForm(userId);
		List<MyPageForm> passForm = new ArrayList<MyPageForm>();
		List<MyPageForm> subscriptionForm = new ArrayList<MyPageForm>();
		this.myPageService.getSubscriptionForm(userId, subscriptionForm, passForm);
		model.addAttribute("ScenarioRegistForm", registForm);
		model.addAttribute("PassForm", passForm);
		model.addAttribute("SubscriptionForm", subscriptionForm);


		return "scenario/mypage";
	}

}
