package com.interceptor;/*
 * Created by Nolva on 2020/7/9.
 */

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 自定义拦截器：pre->controller->post->.jsp->after
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        如果登录页面则放行
        if (request.getRequestURI().contains("login")){
            return true;
        }
        HttpSession session = request.getSession();
//        如果用户已登录也放行
        if (session.getAttribute("activeUser") != null || session.getAttribute("admin") != null){
            return true;
        }
//        用户没有登录跳转到登录页面
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
//        response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
        return false;
    }
}

