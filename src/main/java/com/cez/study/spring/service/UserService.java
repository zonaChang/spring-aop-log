package com.cez.study.spring.service;

import com.cez.study.spring.bean.UserBean;

/**
 * @desc: 
 * @auth: zona
 * @createTime: 2017年6月21日 下午4:51:54
 */
public interface UserService {

	UserBean queryUserById(int id);

}
