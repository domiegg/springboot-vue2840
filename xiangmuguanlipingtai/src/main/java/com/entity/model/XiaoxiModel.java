package com.entity.model;

import com.entity.XiaoxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 消息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XiaoxiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 消息标题
     */
    private String xiaoxiName;


    /**
     * 消息详情
     */
    private String xiaoxiContent;


    /**
     * 推送时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：消息标题
	 */
    public String getXiaoxiName() {
        return xiaoxiName;
    }


    /**
	 * 设置：消息标题
	 */
    public void setXiaoxiName(String xiaoxiName) {
        this.xiaoxiName = xiaoxiName;
    }
    /**
	 * 获取：消息详情
	 */
    public String getXiaoxiContent() {
        return xiaoxiContent;
    }


    /**
	 * 设置：消息详情
	 */
    public void setXiaoxiContent(String xiaoxiContent) {
        this.xiaoxiContent = xiaoxiContent;
    }
    /**
	 * 获取：推送时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：推送时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
