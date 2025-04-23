package com.entity.model;

import com.entity.ZhishiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 知识
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ZhishiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 知识名称
     */
    private String zhishiName;


    /**
     * 知识文件
     */
    private String zhishiFile;


    /**
     * 知识类型
     */
    private Integer zhishiTypes;


    /**
     * 知识详情
     */
    private String zhishiContent;


    /**
     * 知识添加时间
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
	 * 获取：知识名称
	 */
    public String getZhishiName() {
        return zhishiName;
    }


    /**
	 * 设置：知识名称
	 */
    public void setZhishiName(String zhishiName) {
        this.zhishiName = zhishiName;
    }
    /**
	 * 获取：知识文件
	 */
    public String getZhishiFile() {
        return zhishiFile;
    }


    /**
	 * 设置：知识文件
	 */
    public void setZhishiFile(String zhishiFile) {
        this.zhishiFile = zhishiFile;
    }
    /**
	 * 获取：知识类型
	 */
    public Integer getZhishiTypes() {
        return zhishiTypes;
    }


    /**
	 * 设置：知识类型
	 */
    public void setZhishiTypes(Integer zhishiTypes) {
        this.zhishiTypes = zhishiTypes;
    }
    /**
	 * 获取：知识详情
	 */
    public String getZhishiContent() {
        return zhishiContent;
    }


    /**
	 * 设置：知识详情
	 */
    public void setZhishiContent(String zhishiContent) {
        this.zhishiContent = zhishiContent;
    }
    /**
	 * 获取：知识添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：知识添加时间
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
