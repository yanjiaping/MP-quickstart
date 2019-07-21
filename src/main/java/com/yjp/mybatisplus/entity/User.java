package com.yjp.mybatisplus.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
	private Long id;
	private String name;
	private Integer age;
	private String email;
}
