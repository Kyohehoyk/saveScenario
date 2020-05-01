package com.saveScenario.saveScenario.scenario.Util;

import java.util.List;
import java.util.function.Supplier;

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

	public static String setDataSQL (Supplier<String> supplier, String column, List<String> set) {
		String value = CommonInfoUtil.BLANK;
		try {
			value = supplier.get();
		} catch (Exception e) {
			return CommonInfoUtil.BLANK;
		}
		if (value != null && value.length() != 0) {
			set.add(value);
			if (set.size() > 0 ) {
				return " where " + column + " = ? ";
			} else {
				return " and " + column + " = ? ";
			}
		}
		return CommonInfoUtil.BLANK;
	}
}

