package com.newsupplytech.nstdevbase.web;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * 所有请求返回数据格式统一类
 *
 * @Author Bill Lee
 * @Date 2020/4/25 11:33
 **/
@ApiModel(
        value = "接口返回对象",
        description = "接口返回对象"
)
@Data
@Builder
public class RequestResult implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("成功标志")
    private boolean success = true;
    @ApiModelProperty("返回处理消息")
    private String message = "操作成功！";
    @ApiModelProperty("返回代码")
    private Integer code = 0;
    @ApiModelProperty("返回数据对象")
    private Object data;
    @ApiModelProperty("时间戳")
    private long timestamp;

    public RequestResult error500(String message) {
        this.message = message;
        this.code = 500;
        this.success = false;
        return this;
    }

    public RequestResult success(String message) {
        this.message = message;
        this.code = 200;
        this.success = true;
        return this;
    }

    public static RequestResult ok() {
        return ok("操作成功",null);
    }

    public static RequestResult ok(String msg) {
        return ok(msg,null);
    }

    public static RequestResult ok(String msg, Object data) {
        return RequestResult.builder().success(true).code(200).message(msg).data(data).timestamp(System.currentTimeMillis()).build();
    }

    public static RequestResult error(String msg) {
        return error(msg,null);
    }

    public static RequestResult error(String msg, Object data) {
        return RequestResult.builder().success(false).code(500).message(msg).data(data).timestamp(System.currentTimeMillis()).build();
    }
}
