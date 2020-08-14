package com.zynb.controller;

import com.zynb.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping("/dologin")
    public String dologin(String name, String password, HttpSession session){
        if("admin".equals(name)&&"123456".equals(password)){
            User user = new User();
            user.setUsername(name);
            session.setAttribute("user",user);
            return "forward:/product/page";
        }
        return "login";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

}
