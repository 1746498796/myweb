package com.wang.service;

import com.wang.pojo.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerService {

    List<Customer> queryAll();

    int insertCustomer(Customer customer);

    int updateCustomer(Customer customer);

    int deleteCustomer(int id);
    List<Customer> queryPage( int pageNum, int pageBig);
    int deleteAll(int[] ids);

}

