package com.yjp.mybatisplus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yjp.mybatisplus.entity.User;
import com.yjp.mybatisplus.service.ITestUserService;

@RestController
@RequestMapping(value = "/user")
public class TestUserController {
	@Autowired
	private ITestUserService iTestUserService;

	@PostMapping(value = "/userList")
	private List<User> userList(@RequestBody User user) {
		List<User> list = iTestUserService.userList(user);
		return list;
	}
}
