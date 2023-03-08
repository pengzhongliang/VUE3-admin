package com.newsupplytech.nstdevbase.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@TableName(value = "sys_user")
@NoArgsConstructor
public class SysUser extends BaseEntity implements Serializable {


    /**
     * 用户账号
     */
    @TableField(value = "name")
    private String name;

    @TableField(value = "age")
    private Integer age;

    @TableField(value = "sex")
    private Integer sex;

    @TableField(value = "phone")
    private String phone;

    @TableField(value = "address")
    private String address;
}
