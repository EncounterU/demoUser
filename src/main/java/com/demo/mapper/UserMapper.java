package com.demo.mapper;

import com.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface UserMapper {
    void insertUser(User user);

    void deleteUser(Long id);

    void updateUser(User user);

    User findUserByMobile(String mobile);

    List<User> findAllUser();

    User findUserById(Long id);
}
