package com.stx.dao;

import com.stx.entity.Blog;
import com.stx.entity.Comments;

import java.util.List;

public interface CommentsDao {
    void addComments(Comments comments);
    List<Comments> selectCommentsByBlog(Blog blog);
    void deleteComments(Comments comments);

}
