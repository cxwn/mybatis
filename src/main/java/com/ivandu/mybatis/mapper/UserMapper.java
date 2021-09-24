package com.ivandu.mybatis.mapper;

import com.ivandu.mybatis.model.User;

import java.util.List;

public interface UserMapper {
    void insertUser(User user) throws Exception;

    void updateUser(User user) throws Exception;

    void deleteUser(Integer id) throws Exception;

    User selectUserById(Integer id) throws Exception;

    List<User> selectAllUsers() throws Exception;
}
