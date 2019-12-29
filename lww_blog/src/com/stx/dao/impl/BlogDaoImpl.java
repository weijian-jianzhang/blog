package com.stx.dao.impl;

import com.stx.dao.BlogDao;
import com.stx.entity.Blog;
import com.stx.entity.User;
import com.stx.utils.JdbcUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class BlogDaoImpl implements BlogDao {
    JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSource());
    @Override
    public void addBlog(Blog blog) {
        String sql="INSERT INTO blog VALUES(?,?,?,?,?,?,?)";
        try {
            template.update(sql,blog.getBlogId(),blog.getBlogTitle(),blog.getBlogText(),blog.getCreateTime(),blog.getChangeTime(),blog.getType(),blog.getAuthor());
        } catch (DataAccessException e) {
            e.printStackTrace();
        } finally {
        }
        System.out.println("添加成功");

    }

    /*
        查询某个user的所有博客
     */
    @Override
    public List<Blog> selectAllBlogByUser(User user) {
        String sql="SELECT * FROM blog,user WHERE blog.author=user.id AND blog.author=? ORDER BY blog.createTime DESC";
        List<Blog> blogList = template.query(sql, new BeanPropertyRowMapper<>(Blog.class), user.getId());
        return blogList;

    }

    @Override
    public List<Blog> selectAllBlog() {
        String sql="SELECT * FROM blog ORDER BY createTime DESC";
        List<Blog> blogList = template.query(sql, new BeanPropertyRowMapper<>(Blog.class));
        for (Blog b :blogList){
            Integer author = b.getAuthor();
            sql = "SELECT * FROM user WHERE id=?";
            User user1 = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), author);
            b.setUser(user1);
        }
        return blogList;
    }

    @Override
    public Blog deleteBlog(Blog blog) {
        String sql="SELECT * FROM blog WHERE blogId=?";
        Blog blog1 = template.queryForObject(sql, new BeanPropertyRowMapper<>(Blog.class), blog.getBlogId());
        System.out.println(blog1);
        String sql1 = "DELETE FROM blog WHERE blogId=?";
        try{
            template.update(sql1,blog.getBlogId());
            return blog1;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void changeBlog(Blog blog) {
        System.out.println(blog.getBlogId());
        String sql="UPDATE blog SET blogTitle=?,blogText=?,changeTime=?,type=? WHERE blogId=?";

        try {
            template.update(sql,blog.getBlogTitle(),blog.getBlogText(),blog.getChangeTime(),blog.getType(),blog.getBlogId());
            System.out.println("OK");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Blog selectBlogById(Blog blog) {
        String sql = "SELECT * FROM blog WHERE blogId=?";
        Blog blog1 = template.queryForObject(sql, new BeanPropertyRowMapper<>(Blog.class), blog.getBlogId());
        Integer author = blog1.getAuthor();
        sql = "SELECT * FROM user WHERE id=?";
        User user1 = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), author);
        blog1.setUser(user1);
        return blog1;
    }
}
