package com.whs.ssm.api;

import com.whs.ssm.dao.UserDao;
import com.whs.ssm.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 武海升
 * @date 2018/9/28 15:49
 */
@Slf4j
@Component
public class DefaultMessageDel {

    @Autowired
    private UserDao userDao;

    public void handleMessage(String message) {
        log.info("key过期了:"+ message);
        userDao.insert(new User(message));
    }

}
