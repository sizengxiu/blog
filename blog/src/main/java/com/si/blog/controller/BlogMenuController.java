package com.si.blog.controller;

import com.si.blog.model.BlogMenu;
import com.si.blog.model.BlogMenuVo;
import com.si.blog.model.Result;
import com.si.blog.service.BlogMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    /**
     *  点击日志
     * @param:
     * @return:
     * @auther: szx
     * @date: 2020/5/15 22:10
     */
    @RequestMapping("clickBlog")
    public Result clickBlog(@RequestParam("blogId")int blogId) {
        blogMenuService.clickBlog(blogId);
        return new Result();
    }

    /**
     * 根据日志分类获取日志列表
     * @param:
     * @return:
     * @auther: szx
     * @date: 2020/5/15 22:50
     */
    @RequestMapping("getBlogMenuListByType")
    public Result getBlogMenuListByType(@RequestParam("typeCode") String typeCode){
        List<BlogMenu> list=blogMenuService.getBlogMenuListByType(typeCode);
        return new Result(list);
    }
}
