package com.whs.ssm.web;

import com.whs.ssm.entity.User;
import com.whs.ssm.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {


	@Autowired
	private UserService userService;

	@RequestMapping(value = "getUser/{userPhone}")
	public String editItem(@PathVariable("userPhone") Long userPhone, Model model) {
		User user = userService.getByPhone(userPhone);
		model.addAttribute("user", user);
		log.info("执行完毕");
		return "userInfo";
	}


}
