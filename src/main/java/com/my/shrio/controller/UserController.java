package com.my.shrio.controller;

import com.my.shrio.domain.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/index")
    public String index(){
        return "login";
    }

    @ResponseBody
    @RequestMapping("/login")
    public String login(User user){
        System.out.println("user = [" + user.getUsername() +" 密码：" + user.getPassword() + "]");
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        Subject subject = SecurityUtils.getSubject();
        subject.login(usernamePasswordToken);
        subject.isAuthenticated();
        return "登录成功";
    }

    @ResponseBody
    @RequestMapping("/test")
    public String test(User user){
        Subject subject = SecurityUtils.getSubject();
        //检查是否登录
        subject.isAuthenticated();
        subject.checkPermissions("user:delete");
        return "登录成功";
    }

}
