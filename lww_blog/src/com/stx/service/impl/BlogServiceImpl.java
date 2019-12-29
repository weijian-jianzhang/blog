package com.stx.service.impl;

import com.stx.dao.impl.BlogDaoImpl;
import com.stx.entity.Blog;
import com.stx.service.BlogService;

import java.sql.Timestamp;

public class BlogServiceImpl implements BlogService {


    @Override
    public void addBlog(Blog blog) {
        blog.setCreateTime(new Timestamp(System.currentTimeMillis()));
        blog.setChangeTime(new Timestamp(System.currentTimeMillis()));
        new BlogDaoImpl().addBlog(blog);
    }

    @Override
    public void changeBlog(Blog blog) {
        blog.setChangeTime(new Timestamp(System.currentTimeMillis()));
        new BlogDaoImpl().changeBlog(blog);

    }
}
