package io.imfast.webrwd.utils;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;


public class FormUtil {
	@SuppressWarnings("unchecked")
	public static <T> T ToModel(Class<T> clazz, HttpServletRequest request ) {
		T obj = null;
		try {
			obj = clazz.newInstance();
			BeanUtils.populate(obj, request.getParameterMap());
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
			System.out.print(e.getMessage());
		}
		return obj;
		
	}

}
