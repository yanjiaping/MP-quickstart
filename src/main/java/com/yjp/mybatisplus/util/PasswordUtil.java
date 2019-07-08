package com.yjp.mybatisplus.util;

import org.springframework.util.DigestUtils;

public class PasswordUtil {
    public static String toHash(String password) {
        return DigestUtils.md5DigestAsHex(password.getBytes());
    }
}
