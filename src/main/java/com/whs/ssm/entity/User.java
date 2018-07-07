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
	
	private Date createTime;
	
	private int score;
}
