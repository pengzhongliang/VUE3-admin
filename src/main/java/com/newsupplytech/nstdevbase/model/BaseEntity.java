package com.newsupplytech.nstdevbase.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * 基础数据
 *
 * @Author Bill Lee
 * @Date 2020/4/25 11:33
 **/
@Data
public class BaseEntity {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;



    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;


    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Date updateTime;
}
