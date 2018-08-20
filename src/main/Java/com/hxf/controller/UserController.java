package com.hxf.controller;

import com.hxf.bean.Users;
import com.hxf.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by Huangxiaofei on 2018/8/17.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    @RequestMapping("/login")
    public ModelAndView login(Users user, HttpSession session){
        Users loginUser = userService.login(user);
        ModelAndView mv = new ModelAndView("/index.jsp");
        if (loginUser!=null){
            session.setAttribute("loginUser",loginUser);
            mv.setViewName("/product/option");
        }
        mv.addObject("loginError","登陆失败，用户名或密码不正确！");
        return mv;
    }
    @RequestMapping("/quit")
    public ModelAndView quit(HttpSession session){
        ModelAndView mv = new ModelAndView("/index.jsp");
        session.invalidate();
        return mv;
    }
}
