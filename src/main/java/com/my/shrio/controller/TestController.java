package com.my.shrio.controller;


import com.alibaba.fastjson.JSON;
import com.my.shrio.domain.User;
import com.my.shrio.service.IUserRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Set;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private IUserRolesService userRolesService;

    @RequestMapping("/test")
    public String test(){
        Set<String> role = userRolesService.selectRoleByUsername("xiaoming");
        return JSON.toJSONString(role);
    }


}
