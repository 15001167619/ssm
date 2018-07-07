package com.whs.ssm.dao;


import com.whs.ssm.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * @author yingjun
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class UserDaoTest {

    @Autowired
    private UserDao userDao;
	
	@Test
	public void testQueryById() {
		User user=userDao.findByPhone(18768128888L);
		System.out.println(user);
		System.out.println("--------------------------");
	}


}
