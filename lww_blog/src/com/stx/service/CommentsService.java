package com.stx.service;

import com.stx.entity.Blog;
import com.stx.entity.Comments;

import java.util.HashMap;
import java.util.List;

public interface CommentsService {
    Comments addComments(HashMap map);
    List<Comments> showComments(List<Comments> list, Blog blog);
}
