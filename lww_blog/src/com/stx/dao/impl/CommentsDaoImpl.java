package com.stx.dao.impl;

import com.stx.dao.CommentsDao;
import com.stx.entity.Blog;
import com.stx.entity.Comments;
import com.stx.utils.JdbcUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class CommentsDaoImpl implements CommentsDao {
        DataSource ds= JdbcUtils.getDataSource();
        JdbcTemplate template = new JdbcTemplate(ds);
        String sql = "";

    @Override
    public void addComments(Comments comments) {
        sql="INSERT INTO comments VALUES(?,?,?,?,?)";
        try {
            template.update(sql,comments.getId(),comments.getCommentText(),comments.getUser().getId(),comments.getBlog().getBlogId(),comments.getCreateTime());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Comments>  selectCommentsByBlog(Blog blog) {
        sql="SELECT * FROM comments WHERE blogid = ? ORDER BY createTime DESC";
        List<Comments> lists = template.query(sql, new BeanPropertyRowMapper<>(Comments.class), blog.getBlogId());
        return lists;
    }

    @Override
    public void deleteComments(Comments comments) {
        Integer id = comments.getId();
        String sql = "DELETE FROM comments WHERE id = ?";
        template.update(sql,id);
    }


}
