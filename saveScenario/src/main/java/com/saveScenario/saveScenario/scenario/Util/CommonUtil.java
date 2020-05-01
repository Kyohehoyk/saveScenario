package com.saveScenario.saveScenario.scenario.Util;

public class CommonUtil {
	public static boolean isNullOrEmpty (String value) {
		if (value == null || value.equals("")) {
			return true;
		}
		return false;
	}

	public static boolean isNullOrZero (Integer value) {
		if (value == null || value == 0) {
			return true;
		}
		return false;
	}


}

