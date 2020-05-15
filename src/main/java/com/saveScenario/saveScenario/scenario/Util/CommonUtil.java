package com.saveScenario.saveScenario.scenario.Util;

import java.util.List;
import java.util.function.Supplier;
import java.util.regex.Pattern;

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

	public static String setDataSQL (Supplier<String> supplier, String column, List<String> set, boolean isUpdate) {
		String value = CommonInfoUtil.BLANK;
		String rtn = CommonInfoUtil.BLANK;
		try {
			value = supplier.get();
		} catch (Exception e) {
			return rtn;
		}
		if (value != null && value.length() != 0) {
			if (set.size() == 0 ) {
				if (isUpdate) {
					rtn = " set " + column + " = ? ";
				} else {
					rtn = " where " + column + " = ? ";
				}
				set.add(value);
			} else {
				rtn = " and " + column + " = ? ";
				set.add(value);
			}
		}
		return rtn;
	}

	public static boolean isInteger (String value) {
		if (value == null || value.contentEquals(CommonInfoUtil.BLANK)) {
			return false;
		}
		try {
			Integer.valueOf(value);
		} catch (Exception e){
			return false;
		}
		return true;
	}

	public static boolean isFloat (String value) {
		if (value == null || value.contentEquals(CommonInfoUtil.BLANK)) {
			return false;
		}
		try {
			Float.valueOf(value);
		} catch (Exception e){
			return false;
		}
		return true;
	}

	public static boolean isEnglishNumber(String value) {
		if (value == null || value.contentEquals(CommonInfoUtil.BLANK)) {
			return false;
		}
		if (Pattern.matches("^[0-9a-zA-Z]+$", value)) {
			return true;
		} else {
			return false;
		}
	}
}

