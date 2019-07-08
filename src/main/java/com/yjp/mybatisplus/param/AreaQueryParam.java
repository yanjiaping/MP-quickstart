package com.yjp.mybatisplus.param;

import com.yjp.mybatisplus.core.PageParam;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AreaQueryParam extends PageParam {
	private String areaName;
	private Integer priority;
}
