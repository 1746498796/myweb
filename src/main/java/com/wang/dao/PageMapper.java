package com.wang.dao;

import com.wang.pojo.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface PageMapper {
    List queryAll();

    List queryPage(@Param("pageNum") int pageNum,@Param("pageBig") int pageBig);
}
