package com.dyr.dao;

import com.dyr.pojo.User;
import com.dyr.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class UserMapperTest {

    static Logger logger=Logger.getLogger(UserMapperTest.class);

    @Test
    public  void getUserList(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.addUser(new User(8, "温宁", "123"));
        if (res>0){
            System.out.println("添加成功");
        }
        sqlSession.commit();
        sqlSession.close();
    }

//    @Test
//    public void addUser2(){
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        Map<String,Object> map = new HashMap<String, Object>();
//        map.put("id",7);
//        map.put("name","荷兰豆");
//        map.put("pwd","234");
//        int res = mapper.addUser2(map);
//        sqlSession.commit();
//        sqlSession.close();
//
//    }

    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.updateUser(new User(1, "魏无羡", "666"));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.deleteUser(7);
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void tsetLog4j(){
        logger.info("info:进入了testLog4j");
        logger.debug("debug:进入了testLog4j");
        logger.error("error:进入了testLog4j");
    }

    @Test
    public void getUserByLimit(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("startIndex",0);
        map.put("pageSize",2);
        List<User> userList = mapper.getUserByLimit(map);
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();

    }

}
