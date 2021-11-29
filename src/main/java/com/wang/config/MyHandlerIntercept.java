package com.wang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MyHandlerIntercept implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截器");
        Object session = request.getSession().getAttribute("loginSession");
        if (session!=null){
            System.out.println("----------------session不为空----------------");
            return true;
        }else {
            System.out.println("----------------session为空----------------");
            request.getRequestDispatcher("/wang").forward(request,response);
            return false;
        }

    }
}
