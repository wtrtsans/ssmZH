package com.zynb.utils;

import com.zynb.exception.MyException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExceptionResvler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        String msg = "你有问题，你不对劲";
        if(e instanceof MyException){
            msg = ((MyException) e).getMsg();
        }
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("msg",msg);
        System.out.println(e);
        return modelAndView;
    }
}
