package com.yjp.mybatisplus.service.impl.tb;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yjp.mybatisplus.entity.tb.Area;
import com.yjp.mybatisplus.mapper.tb.AreaMapper;
import com.yjp.mybatisplus.param.AreaQueryParam;
import com.yjp.mybatisplus.service.tb.IAreaService;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author yanjiaping
 * @since 2019-04-22
 */
@Service
public class AreaServiceImpl extends ServiceImpl<AreaMapper, Area> implements IAreaService {
	@Autowired
	private AreaMapper areaMapper;

	/**
	 * <p>
	 * 插入一条记录
	 * </p>
	 *
	 * @param entity 实体对象
	 * @return 插入成功记录数
	 */
	@Override
	public int insert(Area area) {
		return areaMapper.insert(area);
	}

	/**
	 * <p>
	 * 根据 ID 删除
	 * </p>
	 *
	 * @param id 主键ID
	 * @return 删除成功记录数
	 */
	@Override
	@Transactional
	public int deleteById(int id) {
		return areaMapper.deleteById(id);
	}

	/**
	 * <p>
	 * 根据 columnMap 条件，删除记录
	 * </p>
	 *
	 * @param columnMap 表字段 map 对象
	 * @return 删除成功记录数
	 */
	@Override
	public int deleteByMap(Map<String, Object> columnMap) {
		return areaMapper.deleteByMap(columnMap);
	}

	/**
	 * <p>
	 * 根据 entity 条件，删除记录
	 * </p>
	 *
	 * @param wrapper 实体对象封装操作类（可以为 null）
	 * @return 删除成功记录数
	 */
	@Override
	public int delete(Area area) {
		return areaMapper.delete(new QueryWrapper<Area>().eq("area_name", area.getAreaName()));
//		return areaMapper.delete(new QueryWrapper<Area>().lambda().eq(Area::getAreaId, area.getAreaId()));
	}

	/**
	 * <p>
	 * 删除（根据ID 批量删除）
	 * </p>
	 *
	 * @param idList 主键ID列表(不能为 null 以及 empty)
	 * @return 删除成功记录数
	 */
	@Override
	public int deleteBatchIds(List<Integer> idList) {
		return areaMapper.deleteBatchIds(idList);
	}

	/**
	 * <p>
	 * 根据 ID 查询
	 * </p>
	 *
	 * @param id 主键ID
	 * @return 实体
	 */
	@Override
	public Area selectById(int id) {
		return areaMapper.selectById(id);
	}

	/**
	 * <p>
	 * 查询（根据ID 批量查询）
	 * </p>
	 *
	 * @param idList 主键ID列表(不能为 null 以及 empty)
	 * @return 实体集合
	 */
	@Override
	public List<Area> selectBatchIds(List<Integer> idList) {
		return areaMapper.selectBatchIds(idList);
	}

	/**
	 * <p>
	 * 查询（根据 columnMap 条件）
	 * </p>
	 *
	 * @param columnMap 表字段 map 对象
	 * @return 实体集合
	 */
	@Override
	public List<Area> selectByMap(Map<String, Object> columnMap) {
		return areaMapper.selectByMap(columnMap);
	}

	/**
	 * <p>
	 * 根据 entity 条件，查询全部记录
	 * </p>
	 *
	 * @param queryWrapper 实体对象封装操作类（可以为 null）
	 * @return 实体集合
	 */
	@Override
	public List<Area> selectList(Area area) {
		QueryWrapper<Area> qw = new QueryWrapper<>();
		/**
		 * allEq
		 */
//		Map<String, Object> map = new HashMap<>();
//		map.put("area_id", area.getAreaId());
//		map.put("remark", area.getRemark());
//		qw.allEq(area.getAreaId() > 11 ? true : false, map, false);

		/**
		 * between
		 */
//		qw.between("area_id", 1, 8);

		/**
		 * like
		 */
//		qw.like("area_name", "东");

		/**
		 * in
		 */
//		List<Integer> values = new ArrayList<>();
//		values.add(1);
//		values.add(2);
//		values.add(3);
//		qw.in("area_id", values);
//		qw.in("area_id", 1, 2, 3);

		/**
		 * inSql
		 */
//		qw.inSql("area_id", "1, 2, 8");
//		qw.inSql("area_name", "'东苑', '北苑'");
//		qw.inSql("area_id", "SELECT area_id FROM tb_area WHERE area_id = 27");

		/**
		 * groupBy
		 */
//		qw.groupBy("priority", "remark");

		/**
		 * orderBy、orderByDesc
		 */
//		qw.orderBy(true, true, "priority", "order_sequence");
//		qw.orderByAsc("priority");
//		qw.orderByDesc("order_sequence");

		/**
		 * OR 嵌套
		 */
//		qw.eq("area_id", 1).or(i -> i.eq("area_name", "北苑").ne("priority", 3));

		/**
		 * select
		 */
//		qw.select("area_id", "area_name", "remark");
		return areaMapper.selectList(qw);
	}

	/**
	 * <p>
	 * 根据 Wrapper 条件，查询全部记录
	 * </p>
	 *
	 * @param queryWrapper 实体对象封装操作类（可以为 null）
	 * @return 字段映射对象 Map 集合
	 */
	@Override
	public List<Map<String, Object>> selectMaps(Area area) {
		QueryWrapper<Area> qw = new QueryWrapper<>();
		return areaMapper.selectMaps(qw);
	}

	/**
	 * <p>
	 * 根据 entity 条件，查询全部记录（并翻页）
	 * </p>
	 *
	 * @param page         分页查询条件（可以为 RowBounds.DEFAULT）
	 * @param queryWrapper 实体对象封装操作类（可以为 null）
	 * @return 实体分页对象
	 */
	@Override
	public IPage<Area> selectPage(Area area) {
		Page<Area> page = new Page<>(1, 5);
		QueryWrapper<Area> qw = new QueryWrapper<>();
		return areaMapper.selectPage(page, qw);
	}

	/**
	 * 使用 Wrapper 自定义SQL
	 */
	@Override
	public List<Area> getAll() {
		return areaMapper.getAll(Wrappers.<Area>lambdaQuery().like(Area::getAreaName, "1"));
	};

	@Override
	public IPage<Area> selectAreaPage(AreaQueryParam areaQueryParam) {
		// 不进行 count sql 优化，解决 MP 无法自动优化 SQL 问题，这时候你需要自己查询 count 部分
		// page.setOptimizeCountSql(false);
		// 当 total 为非 0 时(默认为 0),分页插件不会进行 count 查询
		// 要点!! 分页返回的对象与传入的对象是同一个
		return areaMapper.selectAreaPage(new Page<>(areaQueryParam.getCurrent(), areaQueryParam.getSize()),
				Wrappers.<Area>lambdaQuery().like(Area::getAreaName, "1"));
	}
}
