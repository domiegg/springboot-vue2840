package com.entity.vo;

import com.entity.XiaoxiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 消息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("xiaoxi")
public class XiaoxiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 消息标题
     */

    @TableField(value = "xiaoxi_name")
    private String xiaoxiName;


    /**
     * 消息详情
     */

    @TableField(value = "xiaoxi_content")
    private String xiaoxiContent;


    /**
     * 推送时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：消息标题
	 */
    public String getXiaoxiName() {
        return xiaoxiName;
    }


    /**
	 * 获取：消息标题
	 */

    public void setXiaoxiName(String xiaoxiName) {
        this.xiaoxiName = xiaoxiName;
    }
    /**
	 * 设置：消息详情
	 */
    public String getXiaoxiContent() {
        return xiaoxiContent;
    }


    /**
	 * 获取：消息详情
	 */

    public void setXiaoxiContent(String xiaoxiContent) {
        this.xiaoxiContent = xiaoxiContent;
    }
    /**
	 * 设置：推送时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：推送时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
