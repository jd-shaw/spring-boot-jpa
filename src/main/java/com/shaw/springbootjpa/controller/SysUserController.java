package com.shaw.springbootjpa.controller;

import com.shaw.springbootjpa.entity.SysUser;
import com.shaw.springbootjpa.service.SysUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shaw
 * @date 2023/3/20
 */
@RestController
public class SysUserController {

    @Resource(name = "sysUserService")
    private SysUserService sysUserService;

    @GetMapping("/get-all")
    public List<SysUser> getAll() {
        return sysUserService.findAll();
    }



}
