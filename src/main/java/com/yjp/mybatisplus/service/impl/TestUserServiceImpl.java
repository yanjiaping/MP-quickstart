package com.yjp.mybatisplus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yjp.mybatisplus.entity.User;
import com.yjp.mybatisplus.mapper.TestUserMapper;
import com.yjp.mybatisplus.service.ITestUserService;

@Service
public class TestUserServiceImpl implements ITestUserService {
	@Autowired
	private TestUserMapper testUserMapper;

	@Override
	public List<User> userList(User user) {
		return testUserMapper.selectUserList(user);
	}

}
