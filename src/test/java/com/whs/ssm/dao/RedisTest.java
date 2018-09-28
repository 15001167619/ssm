package com.whs.ssm.dao;

import com.whs.ssm.service.CoreRedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

/**
 * @author 武海升
 * @date 2018/7/25 10:33
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:spring/spring-*.xml"})
public class RedisTest {


    @Resource(name = "redisService")
    private CoreRedisService redisService;

    @Test
    public void testMessage(){

        redisService.addToRedis("whs","武海升",7200);

        String whs = redisService.getRedisValueByKey("whs");
        System.out.println(whs);
    }


}
