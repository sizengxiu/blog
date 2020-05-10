package com.si.blog.service.impl;

import com.si.blog.mapper.BlogMenuMapper;
import com.si.blog.model.BlogMenu;
import com.si.blog.model.BlogMenuVo;
import com.si.blog.service.BlogMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 *
 * @user szx
 * @date 2020/5/9 23:55
 */
@Service
@Slf4j
public class BlogMenuServiceImpl implements BlogMenuService {
    @Autowired
    private BlogMenuMapper blogMenuMapper;
    @Override
    public List<BlogMenuVo> getBlogMenuList() {
        return blogMenuMapper.getBlogMenuList();
    }
}
