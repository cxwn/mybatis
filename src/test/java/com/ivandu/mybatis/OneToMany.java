package com.ivandu.mybatis;

import com.ivandu.mybatis.mapper.CompanyMapper;
import com.ivandu.mybatis.model.Company;
import com.ivandu.mybatis.model.Staff;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.Reader;
import java.util.List;

public class OneToMany {
    public static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void init() throws Exception {
        String resource = "mybatis.cfg.xml";
        Reader reader = Resources.getResourceAsReader(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        reader.close();
    }

    @Test
    public void selectCompanyAndStaffById() {
        Company company;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try (sqlSession) {
            CompanyMapper companyMapper = sqlSession.getMapper(CompanyMapper.class);
            company = companyMapper.selectCompanyAndStaffById(2);
            System.out.println(company.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
