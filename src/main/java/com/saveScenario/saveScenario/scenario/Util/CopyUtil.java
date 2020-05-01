package com.saveScenario.saveScenario.scenario.Util;

import java.util.List;

import org.springframework.beans.BeanUtils;

public class CopyUtil {
	public static <T, U> void copyProperties(List<T> toCopy, List<U> fromCopy, Class<T> type) {
		for (U fromDto : fromCopy) {
			try {
				T toDto = type.newInstance();
				BeanUtils.copyProperties(fromDto, toDto);
				toCopy.add(toDto);
			} catch (InstantiationException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

		}
	}

	public static <T, U> void copyProperty(T toCopy, U fromCopy) {
		BeanUtils.copyProperties(fromCopy, toCopy);
	}
}
