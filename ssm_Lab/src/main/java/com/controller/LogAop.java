//package com.controller;
///*
// * Created by Nolva on 2020/7/9.
// */
//
//import com.domain.SysLog;
//import com.domain.User;
//import com.service.ISysLogService;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.servlet.http.HttpServletRequest;
//import java.lang.reflect.Method;
//import java.util.Date;
//
//@Component
//@Aspect
//public class LogAop {
//
//    private final HttpServletRequest request;
//    private final ISysLogService sysLogService;
////    开始时间
//    private Date visitTime;
////    访问的类
//    private Class clazz;
////    访问的方法
//    private Method method;
//
//    @Autowired
//    public LogAop(ISysLogService sysLogService, HttpServletRequest request) {
//        this.sysLogService = sysLogService;
//        this.request = request;
//    }
//
//    /**
//     * 前置通知 主要获取开始时间，执行的类是哪一个，执行的是哪一个方法
//     * @param jp
//     * @throws NoSuchMethodException
//     */
//    @Before("execution(* com.service.impl.*.*(..))")
//    public void doBefore(JoinPoint jp) throws NoSuchMethodException {
////        当前时间就是开始访问的时间
//        visitTime = new Date();
////        具体要访问的类
//        clazz = jp.getTarget().getClass();
////        获取访问的方法的名称
//        String methodName = jp.getSignature().getName();
////        获取访问的方法的参数
//        Object[] args = jp.getArgs();
//
////        获取具体执行的方法的Method对象
//        if (args == null || args.length == 0) {
////            只能获取无参数的方法
//            method = clazz.getMethod(methodName);
//        } else {
//            Class[] classArgs = new Class[args.length];
//            for (int i = 0; i < args.length; i++) {
//                classArgs[i] = args[i].getClass();
//            }
//            clazz.getMethod(methodName, classArgs);
//        }
//    }
//
//    //后置通知
//    @After("execution(* com.service.impl.*.*(..))")
//    public void doAfter(JoinPoint jp) {
////        获取访问的时长
//        long time = new Date().getTime() - visitTime.getTime();
//        String url = "";
////        获取url
//        if (clazz != null && method != null && clazz != LogAop.class) {
////            1.获取类上的@RequestMapping("/orders")
//            RequestMapping classAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
//            if (classAnnotation != null) {
//                String[] classValue = classAnnotation.value();
////                2.获取方法上的@RequestMapping(xxx)
//                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
//                if (methodAnnotation != null) {
//                    String[] methodValue = methodAnnotation.value();
//                    url = classValue[0] + methodValue[0];
//
////                    获取访问的ip
//                    String ip = request.getRemoteAddr();
//
////                    获取当前操作的用户
////                    从上下文中获取了当前登录的用户
//                    SecurityContext context = SecurityContextHolder.getContext();
//                    User user = (User) context.getAuthentication().getPrincipal();
//                    String username = user.getUsername();
//
////                    将日志相关信息封装到SysLog对象
//                    SysLog sysLog = new SysLog();
////                    执行时长
//                    sysLog.setExecutionTime(time);
//                    sysLog.setIp(ip);
//                    sysLog.setMethod("[类名] " + clazz.getName() + "[方法名] " + method.getName());
//                    sysLog.setUrl(url);
//                    sysLog.setUsername(username);
//                    sysLog.setVisitTime(visitTime);
//                    System.out.println(sysLog);
//
////                    调用Service完成操作
//                    sysLogService.saveSysLog(sysLog);
//                }
//            }
//        }
//
//    }
//
//
//}
