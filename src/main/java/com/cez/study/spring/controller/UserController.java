package com.cez.study.spring.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.cez.study.spring.bean.UserBean;
import com.cez.study.spring.service.UserService;

/**
 * @desc: 
 * @auth: zona
 * @createTime: 2017年6月21日 下午4:51:30
 */
@Controller
public class UserController {
	
	@Resource
	private UserService userService;

	public Map<String , Object> queryUserById(String id, UserBean bean, Map<String, Integer> map) {
		
		Map<String , Object> retMap = new HashMap<>();
		
		UserBean userBean = userService.queryUserById(33); //new UserBean(1, "my name", 24);
		System.out.println("UserController.queryUserById()");
		retMap.put("data", userBean);
		return retMap;
	}
}
