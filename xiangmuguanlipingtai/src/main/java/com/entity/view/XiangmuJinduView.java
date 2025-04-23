package com.entity.view;

import com.entity.XiangmuJinduEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 项目进度
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("xiangmu_jindu")
public class XiangmuJinduView extends XiangmuJinduEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 进度状态的值
		*/
		private String xiangmuJinduValue;



		//级联表 xiangmu
			/**
			* 项目 的 用户
			*/
			private Integer xiangmuYonghuId;
			/**
			* 项目编号
			*/
			private String xiangmuUuidNumber;
			/**
			* 项目名称
			*/
			private String xiangmuName;
			/**
			* 项目类型
			*/
			private Integer xiangmuTypes;
				/**
				* 项目类型的值
				*/
				private String xiangmuValue;
			/**
			* 项目相关文件
			*/
			private String xiangmuFile;
			/**
			* 项目详情
			*/
			private String xiangmuContent;
			/**
			* 项目状态
			*/
			private Integer xiangmuZhuangtaiTypes;
				/**
				* 项目状态的值
				*/
				private String xiangmuZhuangtaiValue;
			/**
			* 逻辑删除
			*/
			private Integer xiangmuDelete;

	public XiangmuJinduView() {

	}

	public XiangmuJinduView(XiangmuJinduEntity xiangmuJinduEntity) {
		try {
			BeanUtils.copyProperties(this, xiangmuJinduEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 进度状态的值
			*/
			public String getXiangmuJinduValue() {
				return xiangmuJinduValue;
			}
			/**
			* 设置： 进度状态的值
			*/
			public void setXiangmuJinduValue(String xiangmuJinduValue) {
				this.xiangmuJinduValue = xiangmuJinduValue;
			}








				//级联表的get和set xiangmu
					/**
					* 获取：项目 的 用户
					*/
					public Integer getXiangmuYonghuId() {
						return xiangmuYonghuId;
					}
					/**
					* 设置：项目 的 用户
					*/
					public void setXiangmuYonghuId(Integer xiangmuYonghuId) {
						this.xiangmuYonghuId = xiangmuYonghuId;
					}

					/**
					* 获取： 项目编号
					*/
					public String getXiangmuUuidNumber() {
						return xiangmuUuidNumber;
					}
					/**
					* 设置： 项目编号
					*/
					public void setXiangmuUuidNumber(String xiangmuUuidNumber) {
						this.xiangmuUuidNumber = xiangmuUuidNumber;
					}
					/**
					* 获取： 项目名称
					*/
					public String getXiangmuName() {
						return xiangmuName;
					}
					/**
					* 设置： 项目名称
					*/
					public void setXiangmuName(String xiangmuName) {
						this.xiangmuName = xiangmuName;
					}
					/**
					* 获取： 项目类型
					*/
					public Integer getXiangmuTypes() {
						return xiangmuTypes;
					}
					/**
					* 设置： 项目类型
					*/
					public void setXiangmuTypes(Integer xiangmuTypes) {
						this.xiangmuTypes = xiangmuTypes;
					}


						/**
						* 获取： 项目类型的值
						*/
						public String getXiangmuValue() {
							return xiangmuValue;
						}
						/**
						* 设置： 项目类型的值
						*/
						public void setXiangmuValue(String xiangmuValue) {
							this.xiangmuValue = xiangmuValue;
						}
					/**
					* 获取： 项目相关文件
					*/
					public String getXiangmuFile() {
						return xiangmuFile;
					}
					/**
					* 设置： 项目相关文件
					*/
					public void setXiangmuFile(String xiangmuFile) {
						this.xiangmuFile = xiangmuFile;
					}
					/**
					* 获取： 项目详情
					*/
					public String getXiangmuContent() {
						return xiangmuContent;
					}
					/**
					* 设置： 项目详情
					*/
					public void setXiangmuContent(String xiangmuContent) {
						this.xiangmuContent = xiangmuContent;
					}
					/**
					* 获取： 项目状态
					*/
					public Integer getXiangmuZhuangtaiTypes() {
						return xiangmuZhuangtaiTypes;
					}
					/**
					* 设置： 项目状态
					*/
					public void setXiangmuZhuangtaiTypes(Integer xiangmuZhuangtaiTypes) {
						this.xiangmuZhuangtaiTypes = xiangmuZhuangtaiTypes;
					}


						/**
						* 获取： 项目状态的值
						*/
						public String getXiangmuZhuangtaiValue() {
							return xiangmuZhuangtaiValue;
						}
						/**
						* 设置： 项目状态的值
						*/
						public void setXiangmuZhuangtaiValue(String xiangmuZhuangtaiValue) {
							this.xiangmuZhuangtaiValue = xiangmuZhuangtaiValue;
						}
					/**
					* 获取： 逻辑删除
					*/
					public Integer getXiangmuDelete() {
						return xiangmuDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setXiangmuDelete(Integer xiangmuDelete) {
						this.xiangmuDelete = xiangmuDelete;
					}










}
