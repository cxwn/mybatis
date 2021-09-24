package com.ivandu.mybatis;

import com.ivandu.mybatis.mapper.UserMapper;
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
    public static void init() throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        reader.close();
    }

    @Test
    public void selectAllUser() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            List<User> userList = sqlSession.selectList("selectAllUsers");
            System.out.println("查找所有用户信息，执行结果如下：");
            for (User user: userList) {
                System.out.printf("%d %s %s\n",user.getId(),user.getUsername(),user.getTelephone());
            }
        }
    }

    @Test
    public void selectUserById() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapper userMapper =  sqlSession.getMapper(UserMapper.class);
            User user = userMapper.selectUserById(1);
            System.out.println("按ID进行查找，结果如下：");
            System.out.println(user.getId() + " " + user.getUsername() + " " + user.getTelephone());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
