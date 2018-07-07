package com.whs.ssm.service;

import com.whs.ssm.entity.User;

public interface UserService {

	User getByPhone(long userPhone);
	 
}
