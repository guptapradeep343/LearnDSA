package com.training.inv.item;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PropertyCopyCheck {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Item i = new Item("pradeep", 65.0, "123");
		SubItem s = new SubItem(null, null, null);
		for (Method method : Item.class.getDeclaredMethods()) {
			if (method.isAnnotationPresent(SystemTableEntryKey.class)) {
				Method submethod = getProperMethod(method);
				submethod.invoke(s, method.invoke(i));
			}
		}
		System.out.println(s.getId() + s.getName());

	}

	private static Method getProperMethod(Method method) throws NoSuchMethodException, SecurityException {
		Method m = SubItem.class.getMethod(method.getName().replace("get", "set"), method.getReturnType());
		return m;
	}

}
