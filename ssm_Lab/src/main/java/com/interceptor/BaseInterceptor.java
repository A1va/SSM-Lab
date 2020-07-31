package com.interceptor;
/*
 * Created by Nolva on 2020/5/28.
 */

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器：pre->controller->post->.jsp->after
 */
public class BaseInterceptor implements HandlerInterceptor {


    /**
     * 预处理：controller方法执行前
     * return true 放行，执行下一个拦截器；若没有下一个，执行controller的方法
     * return false 不放行
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preFirstInterceptor...");
//        可执行跳转页面
//        request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
//        System.out.println("Interceptor 拦截请求！preHandle...");
        return true;
    }

    /**
     * 后处理方法：controller方法执行后，success.jsp执行之前
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("Interceptor postHandle...");
//        request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
    }

    /**
     * .jsp执行之后，该方法才执行。方法体中不可跳转页面
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("Interceptor afterCompletion...");
//        不可跳转页面
    }
}

