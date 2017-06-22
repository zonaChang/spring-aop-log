package com.test;

import java.lang.reflect.Field;

import com.cez.study.spring.bean.UserBean;

/**
 * @desc: 
 * @auth: zona
 * @createTime: 2017年6月22日 上午10:05:13
 */
public class GetFields {

	 private static String[] types = { "java.lang.Integer", "java.lang.Double",  
         "java.lang.Float", "java.lang.Long", "java.lang.Short",  
         "java.lang.Byte", "java.lang.Boolean", "java.lang.Char",  
         "java.lang.String", "int", "double", "long", "short", "byte",  
         "boolean", "char", "float" }; 
	
	 public static void main(String[] args) {
		Object name = "namexxx";
		UserBean userBean = new UserBean();
		Field[] fields = userBean.getClass().getDeclaredFields();  
//		for (Field field : fields) {
		 for (int j = 0; j < fields.length; j++) { 
			
			 fields[j].setAccessible(true);  
			System.out.println(fields[j].getName() + "---");  
		}
	}
	 
	public static String getFieldsValue(Object obj) {
			Field[] fields = obj.getClass().getDeclaredFields();
			
			StringBuilder sb = new StringBuilder();
			sb.append("【");
			for (Field f : fields) {
				f.setAccessible(true);
				try {
					for (String str : types) {
						if (f.getType().getName().equals(str)){
							sb.append(f.getName() + " = " + f.get(obj)+"; ");
						}
					}
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
			sb.append("】");
			return sb.toString();
		}
}
