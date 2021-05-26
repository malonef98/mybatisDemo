package com.dao;

import com.pojo.User;
import com.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {
    @Test
    public void test(){
        //获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSession();
        //执行sql
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> UserList =  userMapper.selectUser();
        for (User user: UserList){
            System.out.println(user.getName() + "\t" + user.getId() + "\t" + user.getPwd());
        }
        sqlSession.close();
    }

    @Test
    public void selectbyid(){
        //获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSession();
        //执行sql
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user =  userMapper.selectUserById(2);
        System.out.println(user.getName());
        sqlSession.close();
    }

    @Test
    public void insertUser(){
        //获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSession();
        //执行sql
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User(5,"王五","zxcvbn");
        int i = userMapper.addUser(user);
        System.out.println(i);

        //提交事务,重点!不写的话不会提交到数据库
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdateUser() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.selectUserById(1);
        user.setPwd("asdfgh");
        int i = mapper.updateUser(user);
        System.out.println(i);
        session.commit(); //提交事务,重点!不写的话不会提交到数据库
        session.close();
    }

    @Test
    public void testDeleteUser() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        int i = mapper.deleteUser(5);
        System.out.println(i);
        session.commit(); //提交事务,重点!不写的话不会提交到数据库
        session.close();
    }
}
