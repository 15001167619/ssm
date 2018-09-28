package com.whs.ssm.dao;

import com.whs.ssm.entity.User;

public interface UserDao {

    User findByPhone(long userPhone);

    int insert(User user);


}
