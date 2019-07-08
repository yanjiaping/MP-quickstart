package com.yjp.mybatisplus.service.tb;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yjp.mybatisplus.entity.tb.Area;
import com.yjp.mybatisplus.param.AreaQueryParam;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yanjiaping
 * @since 2019-04-22
 */
public interface IAreaService extends IService<Area> {
	int insert(Area area);
	
	int deleteById(int id);
	
	int deleteByMap(Map<String, Object> columnMap);
	
	int delete(Area area);
	
	int deleteBatchIds(List<Integer> idList);
	
	Area selectById(int id);
	
	List<Area> selectBatchIds(List<Integer> idList);
	
	List<Area> selectByMap(Map<String, Object> columnMap);
	
	List<Area> selectList(Area area);
	
	List<Map<String, Object>> selectMaps(Area area);
	
	IPage<Area> selectPage(Area area);
	
	List<Area> getAll();
	
	IPage<Area> selectAreaPage(AreaQueryParam areaQueryParam);
}
