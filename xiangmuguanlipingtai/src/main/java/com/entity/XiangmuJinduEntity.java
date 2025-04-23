package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 项目进度
 *
 * @author 
 * @email
 */
@TableName("xiangmu_jindu")
public class XiangmuJinduEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XiangmuJinduEntity() {

	}

	public XiangmuJinduEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 项目
     */
    @TableField(value = "xiangmu_id")

    private Integer xiangmuId;


    /**
     * 进度标题
     */
    @TableField(value = "xiangmu_jindu_name")

    private String xiangmuJinduName;


    /**
     * 进度状态
     */
    @TableField(value = "xiangmu_jindu_types")

    private Integer xiangmuJinduTypes;


    /**
     * 进度相关文件
     */
    @TableField(value = "xiangmu_jindu_file")

    private String xiangmuJinduFile;


    /**
     * 进度详情
     */
    @TableField(value = "xiangmu_jindu_content")

    private String xiangmuJinduContent;


    /**
     * 逻辑删除
     */
    @TableField(value = "xiangmu_jindu_delete")

    private Integer xiangmuJinduDelete;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 设置：项目
	 */
    public Integer getXiangmuId() {
        return xiangmuId;
    }


    /**
	 * 获取：项目
	 */

    public void setXiangmuId(Integer xiangmuId) {
        this.xiangmuId = xiangmuId;
    }
    /**
	 * 设置：进度标题
	 */
    public String getXiangmuJinduName() {
        return xiangmuJinduName;
    }


    /**
	 * 获取：进度标题
	 */

    public void setXiangmuJinduName(String xiangmuJinduName) {
        this.xiangmuJinduName = xiangmuJinduName;
    }
    /**
	 * 设置：进度状态
	 */
    public Integer getXiangmuJinduTypes() {
        return xiangmuJinduTypes;
    }


    /**
	 * 获取：进度状态
	 */

    public void setXiangmuJinduTypes(Integer xiangmuJinduTypes) {
        this.xiangmuJinduTypes = xiangmuJinduTypes;
    }
    /**
	 * 设置：进度相关文件
	 */
    public String getXiangmuJinduFile() {
        return xiangmuJinduFile;
    }


    /**
	 * 获取：进度相关文件
	 */

    public void setXiangmuJinduFile(String xiangmuJinduFile) {
        this.xiangmuJinduFile = xiangmuJinduFile;
    }
    /**
	 * 设置：进度详情
	 */
    public String getXiangmuJinduContent() {
        return xiangmuJinduContent;
    }


    /**
	 * 获取：进度详情
	 */

    public void setXiangmuJinduContent(String xiangmuJinduContent) {
        this.xiangmuJinduContent = xiangmuJinduContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getXiangmuJinduDelete() {
        return xiangmuJinduDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setXiangmuJinduDelete(Integer xiangmuJinduDelete) {
        this.xiangmuJinduDelete = xiangmuJinduDelete;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
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

    @Override
    public String toString() {
        return "XiangmuJindu{" +
            "id=" + id +
            ", xiangmuId=" + xiangmuId +
            ", xiangmuJinduName=" + xiangmuJinduName +
            ", xiangmuJinduTypes=" + xiangmuJinduTypes +
            ", xiangmuJinduFile=" + xiangmuJinduFile +
            ", xiangmuJinduContent=" + xiangmuJinduContent +
            ", xiangmuJinduDelete=" + xiangmuJinduDelete +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
