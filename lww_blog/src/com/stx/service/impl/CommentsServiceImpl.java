package com.stx.service.impl;

import com.stx.dao.impl.BlogDaoImpl;
import com.stx.dao.impl.CommentsDaoImpl;
import com.stx.dao.impl.UserDaoImpl;
import com.stx.entity.Blog;
import com.stx.entity.Comments;
import com.stx.entity.User;
import com.stx.service.CommentsService;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

public class CommentsServiceImpl implements CommentsService {
    private CommentsDaoImpl cd = new CommentsDaoImpl();
    private UserDaoImpl ud = new UserDaoImpl();
    private BlogDaoImpl bd = new BlogDaoImpl();

    @Override
    public Comments addComments(HashMap map) {
        Comments comments = new Comments();
        String commentText = (String)map.get("commentText");
        Integer blogid =Integer.parseInt((String)map.get("blogid"));
        User user = (User)map.get("user");
        Blog blog = bd.selectBlogById(new Blog(blogid));
        comments.setCreateTime(new Timestamp(System.currentTimeMillis()));
        comments.setCommentText(commentText);
        comments.setBlog(blog);
        comments.setUser(user);
        new CommentsDaoImpl().addComments(comments);
        return comments;

    }

    @Override
    public List<Comments> showComments(List<Comments> list,Blog blog) {
        List<Comments> lst = new CommentsDaoImpl().selectCommentsByBlog(blog);
        for (Comments c:lst){
            Integer authorid = c.getAuthorid();
            Integer blogId = c.getBlogId();
            User user = new UserDaoImpl().selectByUserId(new User(authorid));
            Blog blog2 = new BlogDaoImpl().selectBlogById(new Blog(blogId));
            c.setUser(user);
            c.setBlog(blog2);
        }
        return lst;
    }
}
