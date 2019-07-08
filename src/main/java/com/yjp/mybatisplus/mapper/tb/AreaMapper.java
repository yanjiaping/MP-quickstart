package com.yjp.mybatisplus.mapper.tb;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yjp.mybatisplus.entity.tb.Area;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author yanjiaping
 * @since 2019-04-22
 */
public interface AreaMapper extends BaseMapper<Area> {

//	@Select("select * from tb_area ${ew.customSqlSegment}")
	List<Area> getAll(@Param(Constants.WRAPPER) Wrapper<Area> wrapper);

	IPage<Area> selectAreaPage(Page<Area> page, @Param(Constants.WRAPPER) Wrapper<Area> wrapper);

}
