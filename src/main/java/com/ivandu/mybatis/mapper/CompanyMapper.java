package com.ivandu.mybatis.mapper;

import com.ivandu.mybatis.model.Company;

public interface CompanyMapper {
    Company selectCompanyById(Integer id) throws Exception;
}
