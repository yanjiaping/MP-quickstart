package com.yjp.mybatisplus.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yjp.mybatisplus.entity.User;

public interface TestUserMapper extends BaseMapper<User> {
	List<User> selectUserList(User user);
}
