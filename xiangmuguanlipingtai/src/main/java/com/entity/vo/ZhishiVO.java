package com.entity.vo;

import com.entity.ZhishiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 知识
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("zhishi")
public class ZhishiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 知识名称
     */

    @TableField(value = "zhishi_name")
    private String zhishiName;


    /**
     * 知识文件
     */

    @TableField(value = "zhishi_file")
    private String zhishiFile;


    /**
     * 知识类型
     */

    @TableField(value = "zhishi_types")
    private Integer zhishiTypes;


    /**
     * 知识详情
     */

    @TableField(value = "zhishi_content")
    private String zhishiContent;


    /**
     * 知识添加时间
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
	 * 设置：知识名称
	 */
    public String getZhishiName() {
        return zhishiName;
    }


    /**
	 * 获取：知识名称
	 */

    public void setZhishiName(String zhishiName) {
        this.zhishiName = zhishiName;
    }
    /**
	 * 设置：知识文件
	 */
    public String getZhishiFile() {
        return zhishiFile;
    }


    /**
	 * 获取：知识文件
	 */

    public void setZhishiFile(String zhishiFile) {
        this.zhishiFile = zhishiFile;
    }
    /**
	 * 设置：知识类型
	 */
    public Integer getZhishiTypes() {
        return zhishiTypes;
    }


    /**
	 * 获取：知识类型
	 */

    public void setZhishiTypes(Integer zhishiTypes) {
        this.zhishiTypes = zhishiTypes;
    }
    /**
	 * 设置：知识详情
	 */
    public String getZhishiContent() {
        return zhishiContent;
    }


    /**
	 * 获取：知识详情
	 */

    public void setZhishiContent(String zhishiContent) {
        this.zhishiContent = zhishiContent;
    }
    /**
	 * 设置：知识添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：知识添加时间
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
