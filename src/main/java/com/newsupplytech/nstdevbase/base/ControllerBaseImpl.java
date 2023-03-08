package com.newsupplytech.nstdevbase.base;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.newsupplytech.nstdevbase.model.BaseEntity;
import com.newsupplytech.nstdevbase.utils.HttpQueryWrapper;
import com.newsupplytech.nstdevbase.web.RequestResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 基础 Controller  基础的时间方法
 *
 * @Author Bill Lee
 * @Date 2020/4/25 11:33
 **/
public abstract class ControllerBaseImpl<S extends ServiceImpl, E extends BaseEntity>{
    @Autowired
    protected S baseService;

    @Autowired
    protected HttpServletRequest request;

    @PostMapping
    @ApiOperation("| 新增")
    public RequestResult create(@RequestBody E entity) {
        try {
            baseService.save(entity);
            return RequestResult.ok("新增成功",entity);
        } catch (Exception e) {
            return RequestResult.error(e.getMessage());
        }
    }

    @PutMapping
    @ApiOperation("| 更新")
    public RequestResult update(@RequestBody E entity) {
        if (entity.getId() == null) {
            return RequestResult.error("ID不能为空");
        }
        try {
            baseService.saveOrUpdate(entity);
            return RequestResult.ok("更新完成",entity);
        } catch (Exception e) {
            return RequestResult.error(e.getMessage());
        }
    }

    @DeleteMapping("remove/{id}")
    @ApiOperation("| 根据ID删除")
    public RequestResult delete(@PathVariable("id") String id) {
        if (id.contains(",")){
            baseService.removeByIds(Arrays.asList(id.split(",")));
            return RequestResult.ok("删除成功");
        }
        baseService.removeById(id);
        return RequestResult.ok("删除成功");
    }

    @GetMapping("{id}")
    @ApiOperation("| 单个获取")
    public RequestResult get(@PathVariable("id") Long id) {
        try {
            E entity = (E) baseService.getById(id);
            return RequestResult.ok("操作完成", entity);
        } catch (Exception e) {
            return RequestResult.error(e.getMessage());
        }
    }

    @GetMapping("list")
    @ApiOperation("| 分页查询*")
    public RequestResult list(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
                              @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        QueryWrapper<E> queryWrapper = HttpQueryWrapper.genQueryWrapper(request.getParameterMap());
        IPage<E> page = new Page<>(pageNum, pageSize);
        baseService.page(page, queryWrapper);
        return RequestResult.ok("请求成功", page);
    }
}
