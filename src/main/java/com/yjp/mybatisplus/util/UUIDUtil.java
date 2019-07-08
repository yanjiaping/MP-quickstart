package com.yjp.mybatisplus.util;

import java.util.UUID;

public class UUIDUtil {
	public static String generate32UUID() {
		String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
		return uuid;
	}
}
