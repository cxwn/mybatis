package com.ivandu.mybatis.mapper;

import com.ivandu.mybatis.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.*;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class UserMapperTest {
    private static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void init() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            reader.close();
        } catch (IOException ignore) {
            ignore.printStackTrace();
        }
    }

    @Test
    public void selectAllUser() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            List<User> userList = sqlSession.selectList("selectAllUser");
            printUserList(userList);
        }
    }

    private void printUserList(List<User> userList) {
        for (User user: userList) {
            System.out.printf("%d%s %s\n",user.getId(),user.getUsername(),user.getPassword());
        }
    }
}
