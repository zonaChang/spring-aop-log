package com.cez.study.spring.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @desc: 
 * @auth: zona
 * @createTime: 2017年6月21日 下午4:40:24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserBean {

	private Integer id;
	
	private String name;
	
	private Integer age;
}
