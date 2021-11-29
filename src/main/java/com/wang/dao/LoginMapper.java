package com.wang.dao;

import com.wang.pojo.Login;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface LoginMapper {
    Login queryByUserName(@Param("userName") String userName);
}
