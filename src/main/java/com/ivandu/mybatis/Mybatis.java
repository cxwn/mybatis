package com.ivandu.mybatis;

import com.ivandu.mybatis.mapper.UserMapper;
import com.ivandu.mybatis.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class Mybatis {
    public static void main(String[] args) {
        String resource = "mybatis.cfg.xml";
        SqlSessionFactory sqlSessionFactory = null;
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert reader != null;
                reader.close();
            } catch (IOException re) {
                re.printStackTrace();
            }
        }
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(31);
        user.setUsername("Musk");
        user.setTelephone("13813813806");
        try {
            userMapper.insertUser(user);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
}
