package com.whs.ssm.api;

import com.whs.ssm.service.CoreRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



/**
 * @author 武海升
 * @date 2018/7/5 14:37
 */
@Controller
@WebAppConfiguration
@RequestMapping(value = "add", produces = "application/json;charset=UTF-8")
public class ApiController {

    @Autowired
    private CoreRedisService redisService;

    @ResponseBody
    @RequestMapping(value = "addRedis", method = RequestMethod.GET)
    public String add() {
        redisService.addToRedis("whs","武海升",20);
        return "success";
    }
}
