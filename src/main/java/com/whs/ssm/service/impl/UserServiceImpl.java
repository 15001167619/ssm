package com.whs.ssm.service.impl;

import com.whs.ssm.dao.UserDao;
import com.whs.ssm.entity.User;
import com.whs.ssm.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class UserServiceImpl implements UserService {


	@Autowired
	private UserDao userDao;


	@Override
	public User getByPhone(long userPhone) {
		return userDao.findByPhone(userPhone);
	}
}
