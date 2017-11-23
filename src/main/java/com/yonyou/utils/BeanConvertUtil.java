package com.yonyou.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.yonyou.exception.BusinessException;

public class BeanConvertUtil {

	public static <T> List<T> convert(List<? extends Object> sourceList, Class<T> targetClazz) {
		try {
			List<T> targetList = new ArrayList<>();
			for (Object source : sourceList) {
				T target;
				target = targetClazz.newInstance();
				BeanUtils.copyProperties(source, target);
				targetList.add(target);
			}
			return targetList;
		} catch (Exception e) {
			throw new BusinessException(e.getMessage(), e);
		}
	}

	public static <T> T convert(Object source, Class<T> targetClazz) {
		try {
			T target = targetClazz.newInstance();
			BeanUtils.copyProperties(source, target);
			return target;
		} catch (Exception e) {
			throw new BusinessException(e.getMessage(), e);
		}
	}
}
