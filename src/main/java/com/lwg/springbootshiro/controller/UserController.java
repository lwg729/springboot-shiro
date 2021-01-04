package com.lwg.springbootshiro.controller;

import com.lwg.springbootshiro.pojo.User;
import com.lwg.springbootshiro.service.impl.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 功能描述：用户登录
 *
 * @Author: lwg
 * @Date: 2021/1/3 12:19
 */

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    //注册
    @RequestMapping("/register")
    public String register(User user){
        try {
            userService.register(user);
            return "redirect:/login.jsp";
        }catch (Exception e){
            e.printStackTrace();
            return "redirect:/register.jsp";
        }
    }
    //退出登录
    @RequestMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:login.jsp";
    }
    /**
     * 用来处理身份认证
     */

    @RequestMapping("/login")
    public String login(String username,String password){
        Subject subject = SecurityUtils.getSubject();

        try {
            subject.login(new UsernamePasswordToken(username,password));
            return "redirect:/index.jsp";
        }catch (UnknownAccountException e){
            System.out.println("用户名错误");
        }catch (IncorrectCredentialsException e){
            System.out.println("密码错误");
        }
        return "redirect:/login.jsp";
    }
}
