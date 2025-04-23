package com.entity.view;

import com.entity.ZhishiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 知识
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("zhishi")
public class ZhishiView extends ZhishiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 知识类型的值
		*/
		private String zhishiValue;



	public ZhishiView() {

	}

	public ZhishiView(ZhishiEntity zhishiEntity) {
		try {
			BeanUtils.copyProperties(this, zhishiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 知识类型的值
			*/
			public String getZhishiValue() {
				return zhishiValue;
			}
			/**
			* 设置： 知识类型的值
			*/
			public void setZhishiValue(String zhishiValue) {
				this.zhishiValue = zhishiValue;
			}










}
