package com.demo.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {
    //日志记录异常
    private final Logger logger= LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(HttpServletRequest httpServletRequest,Exception e){
        logger.error("Request Url ： {}，Exception : {}",httpServletRequest.getRequestURL(),e);
        //将异常信息载入视图返回给前端页面
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("url",httpServletRequest.getRequestURL());
        modelAndView.addObject("exception",e);
        modelAndView.setViewName("error/error");
        return modelAndView;
    }
}
