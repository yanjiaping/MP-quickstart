package com.yjp.mybatisplus.controller.tb;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yjp.mybatisplus.core.Result;
import com.yjp.mybatisplus.entity.tb.Area;
import com.yjp.mybatisplus.param.AreaQueryParam;
import com.yjp.mybatisplus.service.tb.IAreaService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yanjiaping
 * @since 2019-04-22
 */
@RestController
@RequestMapping("/tb/area")
public class AreaController {
	@Autowired
	private IAreaService iAreaService;
	
	@PostMapping("/insert")
	private int insert(@RequestBody Area area) {
		return iAreaService.insert(area);
	}
	
	@GetMapping("/deleteById")
	private int deleteById(@RequestParam() int id) {
		return iAreaService.deleteById(id);
	}
	
	@PostMapping("/deleteByMap")
	private int deleteByMap(@RequestBody Map<String, Object> columnMap) {
		return iAreaService.deleteByMap(columnMap);
	}
	
	@PostMapping("/delete")
	private int delete(@RequestBody Area area) {
		return iAreaService.delete(area);
	}
	
	@PostMapping("/deleteBatchIds")
	private int deleteBatchIds(@RequestBody List<Integer> idList) {
		return iAreaService.deleteBatchIds(idList);
	}
	
	@PostMapping("/updateById")
	private boolean updateById(@RequestBody Area area) {
		return iAreaService.updateById(area);
	}
	
	@PostMapping("/update")
	private boolean update(@RequestBody Area area) {
		UpdateWrapper<Area> uw = new UpdateWrapper<>();
		uw.set("area_name", "。。。").set("remark", "。。。。。。").eq("area_id", 11);
		
//		Map<String, Object> eqMap = new HashMap<>();
//		eqMap.put("area_id", area.getAreaId());
//		uw.allEq(eqMap);
//		return iAreaService.update(area, uw);
		
		uw.setSql("area_name = '西苑', priority = 2, remark = '。。。。。。'").eq("area_id", 11);
		return iAreaService.update(uw);
	}
	
	@GetMapping("/selectById")
	private Area selectById(@RequestParam int id) {
		return iAreaService.selectById(id);
	}
	
	@PostMapping("/selectBatchIds")
	private List<Area> selectBatchIds(@RequestBody List<Integer> ids) {
		return iAreaService.selectBatchIds(ids);
	}
	
	@PostMapping("/selectByMap")
	private List<Area> selectByMap(@RequestBody Map<String, Object> columnMap) {
		return iAreaService.selectByMap(columnMap);
	}
	
	@PostMapping("/selectList")
	private List<Area> selectList(@RequestBody Area area) {
		return iAreaService.selectList(area);
	}
	
	@PostMapping("/selectMaps")
	private List<Map<String, Object>> selectMaps(@RequestBody Area area) {
		return iAreaService.selectMaps(area);
	}
	
	@PostMapping("/selectPage")
	private IPage<Area> selectPage(@RequestBody Area area) {
		return iAreaService.selectPage(area);
	}
	
	/**
	* <p>
	* 插入（批量）
	* </p>
	* @param entityList 实体对象集合
	* @param batchSize  插入批次数量
	 */
	@PostMapping("/saveBatch")
	private boolean saveBatch(@RequestBody List<Area> areaList) {
		return iAreaService.saveBatch(areaList, 10);
	}
	
	/**
	 * <p>
	 * 批量修改插入
	 * </p>
	 *
	 * @param entityList 实体对象集合
	 */
	@PostMapping("/saveOrUpdateBatch")
	private boolean saveOrUpdateBatch(@RequestBody List<Area> areaList) {
		return iAreaService.saveOrUpdateBatch(areaList);
	}
	
	/**
	 * 使用 Wrapper 自定义SQL
	 */
	@PostMapping("/getAll")
	private List<Area> getAll() {
		return iAreaService.getAll();
	}
	
	/**
	 * 使用 Wrapper 自定义SQL，分页
	 */
	@PostMapping("/selectAreaPage")
	public Result selectAreaPage(@RequestBody AreaQueryParam areaQueryParam) {
		IPage<Area> iPage = iAreaService.selectAreaPage(areaQueryParam);
		return Result.quickOK(iPage);
	}
	
//	Unsatisfied dependency expressed through field 'result';
//	nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException: 
//	No qualifying bean of type 'com.yjp.mybatisplus.core.Result' available: 
//		expected at least 1 bean which qualifies as autowire candidate. 
//		Dependency annotations: {@org.springframework.beans.factory.annotation.Autowired(required=true)}

}

