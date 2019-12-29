package com.stx.dao.impl;

import com.stx.dao.UserDao;
import com.stx.entity.User;
import com.stx.utils.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;


public class UserDaoImpl implements UserDao {
    //声明JDBCTemplate对象共用
   private JdbcTemplate template=new JdbcTemplate(JdbcUtils.getDataSource());
    @Override
    public List<User> selectAll() {
        String sql="SELECT * FROM user";
        List<User> list = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return list;
    }

    @Override
    public User selectByUserId(User user) {
        String sql="SELECT * FROM user WHERE id =?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<>(User.class),user.getId());

    }

    @Override
    public User selectByUserName(User user) {
        try {
            String sql = "SELECT * FROM user WHERE userName=?";
            return template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), user.getUserName());
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public void Register(User user) {
        String sql="INSERT INTO user(userName,passWord,registrationDate,lastLoginTime,question,answer,description,sex,birthday) VALUES(?,?,?,?,?,?,?,?,?)";
        template.update(sql,user.getUserName(),user.getPassWord(),user.getRegistrationDate(),user.getLastLoginTime(),user.getQuestion(),user.getAnswer(), user.getDescription(),user.getSex(),user.getBirthday());
    }

    @Override
    public void forget(User user) {
        String sql="UPDATE user SET passWord=? WHERE userName=?";
        template.update(sql,user.getPassWord(),user.getUserName());
    }

    @Override
    public void delete(User user){
        String sql = "DELETE FROM user WHERE userName=?";
        template.update(sql,user.getUserName());
    }
}
