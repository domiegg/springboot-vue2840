package com.dao;

import com.entity.XiangmuJinduEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XiangmuJinduView;

/**
 * 项目进度 Dao 接口
 *
 * @author 
 */
public interface XiangmuJinduDao extends BaseMapper<XiangmuJinduEntity> {

   List<XiangmuJinduView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
