package com.yjp.mybatisplus.core;

import javax.validation.constraints.DecimalMin;
import lombok.Data;

@Data
public class PageParam {
	@DecimalMin("1")
	private Integer current = 1;// 当前页号
	@DecimalMin("5")
	private Integer size = 2;// 每页多少条记录

}
