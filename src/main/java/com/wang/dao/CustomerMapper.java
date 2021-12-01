package com.wang.dao;

import com.wang.pojo.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CustomerMapper {

    List<Customer> queryAll();

    int insertCustomer(Customer customer);

    int updateCustomer(Customer customer);

    int deleteCustomer(@Param("id")int id);

    List<Customer> queryPage(@Param("pageNum") int pageNum,@Param("pageBig") int pageBig);

    int deleteAll(int[] ids);


}
