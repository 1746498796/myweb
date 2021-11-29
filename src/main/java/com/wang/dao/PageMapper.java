package com.wang.dao;

import com.wang.pojo.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface PageMapper {
    List<Customer> queryAll();

    List<Customer> queryPage(int pageNum,int pageBig);
}
