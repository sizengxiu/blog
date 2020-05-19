package com.si.blog.controller;

import com.si.blog.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @user szx
 * @date 2020/5/14 22:45
 */
@RequestMapping("test")
@RestController
public class TestController {

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("setRedis")
    public Object setRedis(@RequestParam("key") String key, @RequestParam("value") String value){
        redisUtil.set(key,value);
        return redisUtil.get(key);
    }
    @RequestMapping("getRedis")
    public Object getRedis(@RequestParam("key") String key){
        return redisUtil.get(key);
    }
}
