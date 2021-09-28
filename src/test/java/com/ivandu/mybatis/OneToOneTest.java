package com.ivandu.mybatis;

import com.ivandu.mybatis.mapper.CompanyMapper;
import com.ivandu.mybatis.model.Company;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.InputStream;

public class OneToOneTest {

    public static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void init() throws Exception{
        String resource = "mybatis.cfg.xml";
        InputStream reader = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        reader.close();
    }

    @Test
    public void selectCompanyById(){
        Company company;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try (sqlSession) {
            CompanyMapper companyMapper = sqlSession.getMapper(CompanyMapper.class);
            company = companyMapper.selectCompanyById(2);
            System.out.println(company.getId() + "\t" +
                    company.getName() + "\t" +
                            company.getCeo().getAge() + "\t" +
                            company.getCeo().getId() + "\t" +
                            company.getCeo().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
