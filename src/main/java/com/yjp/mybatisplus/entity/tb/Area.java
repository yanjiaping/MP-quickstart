package com.yjp.mybatisplus.entity.tb;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author yanjiaping
 * @since 2019-04-22
 */
@TableName("tb_area")
@Data
public class Area implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(value = "area_id", type = IdType.AUTO)
	private Integer areaId;

	private String areaName;

	private Integer priority;

	private String remark;
	
	private Integer orderSequence;
	
	@TableLogic
	private String validStatus;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createTime;

	private LocalDateTime updateTime;
}
