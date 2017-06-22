package com.test;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cez.study.spring.bean.UserBean;
import com.cez.study.spring.controller.UserController;

/**
 * @desc: 
 * @auth: zona
 * @createTime: 2017年6月21日 下午5:19:48
 */
public class Check {

	@Test
	public void queryUserBean() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserBean userBean = new UserBean(1000, "logName", 2400);
		Map<String, Integer> map = new HashMap<>();
		map.put("aa", 11);
		map.put("bb", 22);
		map.put("cc", 33);
		UserController controller = (UserController) context.getBean("userController");
		System.out.println(controller.queryUserById("2", userBean,map));
	}
	
	@Test
	public void checkBranch() {
		
	}
	
	@Test
	public void testOther() {
		String namex = "name---";
		 Field[] fields = namex.getClass().getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			System.out.println(field.getName());
		}
//		System.out.println(namex.getClass().getDeclaredFields()[0].getName());
	}
}
