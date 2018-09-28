package com.whs.ssm.entity;

import lombok.Data;

import java.util.Date;


/**
 * 用户
 * @author  yingjun
 *
 */
@Data
public class User {
	
	private long userId;
	
	private String userName;
	
	private long userPhone;

	public User (String userName){

		this.userName = userName;

	}

}
