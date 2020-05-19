package com.si.blog.controller;

import com.si.blog.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *  全局controller异常处理
 *  @user szx
 * @date 2020/5/15 22:39
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionResolver {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handleException(Exception e) {
        // 打印异常堆栈信息
        log.error(e.getMessage(), e);
        return Result.getFailInstance("服务器响应异常！");
    }
}
