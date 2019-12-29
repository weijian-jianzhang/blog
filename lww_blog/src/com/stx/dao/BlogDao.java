package com.stx.dao;

import com.stx.entity.Blog;
import com.stx.entity.User;

import java.util.List;

public interface BlogDao {
    void addBlog(Blog blog);
    List<Blog> selectAllBlogByUser(User user);
    List<Blog> selectAllBlog();
    Blog deleteBlog(Blog blog);
    void changeBlog(Blog blog);
    Blog selectBlogById(Blog blog);

}
