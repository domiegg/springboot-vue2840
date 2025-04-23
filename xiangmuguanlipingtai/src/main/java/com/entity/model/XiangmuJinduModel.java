package com.entity.model;

import com.entity.XiangmuJinduEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 项目进度
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XiangmuJinduModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 项目
     */
    private Integer xiangmuId;


    /**
     * 进度标题
     */
    private String xiangmuJinduName;


    /**
     * 进度状态
     */
    private Integer xiangmuJinduTypes;


    /**
     * 进度相关文件
     */
    private String xiangmuJinduFile;


    /**
     * 进度详情
     */
    private String xiangmuJinduContent;


    /**
     * 逻辑删除
     */
    private Integer xiangmuJinduDelete;


    /**
     * 添加时间
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
	 * 获取：项目
	 */
    public Integer getXiangmuId() {
        return xiangmuId;
    }


    /**
	 * 设置：项目
	 */
    public void setXiangmuId(Integer xiangmuId) {
        this.xiangmuId = xiangmuId;
    }
    /**
	 * 获取：进度标题
	 */
    public String getXiangmuJinduName() {
        return xiangmuJinduName;
    }


    /**
	 * 设置：进度标题
	 */
    public void setXiangmuJinduName(String xiangmuJinduName) {
        this.xiangmuJinduName = xiangmuJinduName;
    }
    /**
	 * 获取：进度状态
	 */
    public Integer getXiangmuJinduTypes() {
        return xiangmuJinduTypes;
    }


    /**
	 * 设置：进度状态
	 */
    public void setXiangmuJinduTypes(Integer xiangmuJinduTypes) {
        this.xiangmuJinduTypes = xiangmuJinduTypes;
    }
    /**
	 * 获取：进度相关文件
	 */
    public String getXiangmuJinduFile() {
        return xiangmuJinduFile;
    }


    /**
	 * 设置：进度相关文件
	 */
    public void setXiangmuJinduFile(String xiangmuJinduFile) {
        this.xiangmuJinduFile = xiangmuJinduFile;
    }
    /**
	 * 获取：进度详情
	 */
    public String getXiangmuJinduContent() {
        return xiangmuJinduContent;
    }


    /**
	 * 设置：进度详情
	 */
    public void setXiangmuJinduContent(String xiangmuJinduContent) {
        this.xiangmuJinduContent = xiangmuJinduContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getXiangmuJinduDelete() {
        return xiangmuJinduDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setXiangmuJinduDelete(Integer xiangmuJinduDelete) {
        this.xiangmuJinduDelete = xiangmuJinduDelete;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：添加时间
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
