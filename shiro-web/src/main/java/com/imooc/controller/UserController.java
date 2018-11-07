package com.imooc.controller;

import com.imooc.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @RequestMapping(value="/sublogin",method= RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public String userLogin(User user){
        UsernamePasswordToken token=new UsernamePasswordToken(user.getName(),user.getPassword());
        Subject subject= SecurityUtils.getSubject();
        try{
            subject.login(token);
        }catch (Exception e){
            return e.getMessage();
        }
        if(subject.hasRole("admin")){
            return "权限正确";
        }
        return "权限失败";
    }
}
