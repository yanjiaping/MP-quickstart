package com.yjp.mybatisplus.service;

import java.util.List;

import com.yjp.mybatisplus.entity.User;

public interface ITestUserService {
	List<User> userList(User user);
}
