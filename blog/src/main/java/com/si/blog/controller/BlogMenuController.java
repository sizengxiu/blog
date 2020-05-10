package com.si.blog.controller;

import com.si.blog.model.BlogMenu;
import com.si.blog.model.BlogMenuVo;
import com.si.blog.model.Result;
import com.si.blog.service.BlogMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * description
 *
 * @user Administrator
 * @date 2020/5/9 23:56
 */
@RequestMapping("blogMenu")
@RestController
public class BlogMenuController {

    @Autowired
    private BlogMenuService blogMenuService;

    /**
     * 获取菜单列表
     *
     * @return:
     * @auther: szx
     * @date: 2020/5/9 23:18
     */
    @RequestMapping("getBlogMenuList")
    public Result getBlogMenuList() {
        List<BlogMenuVo> blogMenuList = blogMenuService.getBlogMenuList();
        return new Result(blogMenuList);
    }
}
