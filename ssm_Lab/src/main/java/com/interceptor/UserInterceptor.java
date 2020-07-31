package com.interceptor;/*
 * Created by Nolva on 2020/7//9.
 */

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        boolean flag = false;
        HttpSession session = request.getSession();
        //        如果登录页面则放行
        if (request.getRequestURI().contains("user")){
            flag = session.getAttribute("admin") != null;
        }
//        如果用户已登录也放行

//        用户没有登录跳转到登录页面
        request.getRequestDispatcher("/WEB-INF/jsp/failure.jsp").forward(request, response);
//        response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
        return flag;
    }
}
