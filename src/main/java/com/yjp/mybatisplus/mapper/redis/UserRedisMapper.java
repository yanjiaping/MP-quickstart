package com.yjp.mybatisplus.mapper.redis;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.yjp.mybatisplus.core.AuthorizedUser;

@Component
public class UserRedisMapper {
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	private static final String tableName = "User:";

	/**
	 * 从redis获取用户信息 无数据时返回null
	 */
	public AuthorizedUser getAuthorizedUser(String token) {
		AuthorizedUser authorizedUser = null;
		String key = tableName + token;
		String userJsonStr = stringRedisTemplate.opsForValue().get(key);
		if (StringUtils.isNotBlank(userJsonStr)) {
			authorizedUser = JSON.parseObject(userJsonStr, AuthorizedUser.class);
		}
		return authorizedUser;
	}

	/**
	 * Read userInfo from http header
	 */
	public AuthorizedUser getAuthorizedUser(HttpHeaders headers) {
		String token = headers.getFirst("Authorization");
		AuthorizedUser authorizedUser = getAuthorizedUser(token);
		return authorizedUser;
	}

	/**
	 * Add userInfo to Redis
	 */
	public void setAuthorizedUser(String keyName, AuthorizedUser authorizedUser, long expiredTime) {
		String key = tableName + keyName;
		stringRedisTemplate.opsForValue().set(key, JSON.toJSONString(authorizedUser), expiredTime, TimeUnit.SECONDS);
	}

	/**
	 * 重新设置用户token超时时间
	 */
	public Boolean expireAuthorizedUser(String keyName, long expiredTime) {
		String key = tableName + keyName;
		return stringRedisTemplate.expire(key, expiredTime, TimeUnit.SECONDS);
	}

	/**
	 * 移除用户token超时时间，变为永久
	 */
	public Boolean persistAuthorizedUser(String keyName) {
		String key = tableName + keyName;
		return stringRedisTemplate.persist(key);
	}

	/**
	 * Remove userInfo from Redis
	 */
	public void removeAuthorizedUser(String token) {
		String key = tableName + token;
		stringRedisTemplate.delete(key);
	}
}
