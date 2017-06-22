package com.cez.study.spring.service.impl;

import org.springframework.stereotype.Service;

import com.cez.study.spring.bean.UserBean;
import com.cez.study.spring.service.UserService;

/**
 * @desc: 
 * @auth: zona
 * @createTime: 2017年6月21日 下午4:52:42
 */
@Service
public class UserServiceImpl implements UserService {

	@Override
	public UserBean queryUserById(int id) {
		return new UserBean(1, "my name", 24);
	}

}
