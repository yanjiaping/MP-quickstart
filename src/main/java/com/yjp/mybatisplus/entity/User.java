package com.yjp.mybatisplus.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
	private Long id;
	private String name;
	private Integer age;
	private String email;
}
