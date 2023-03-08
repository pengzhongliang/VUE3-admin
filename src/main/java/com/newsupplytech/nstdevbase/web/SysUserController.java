package com.newsupplytech.nstdevbase.web;


import com.newsupplytech.nstdevbase.base.ControllerBaseImpl;
import com.newsupplytech.nstdevbase.model.SysUser;
import com.newsupplytech.nstdevbase.service.SysUserService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "【系统基础】用户信息管理")
@RequestMapping("sys/user")
public class SysUserController extends ControllerBaseImpl<SysUserService, SysUser> {


}
