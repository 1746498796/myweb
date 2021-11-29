package com.wang.serviceImpl;

import com.wang.dao.CustomerMapper;
import com.wang.pojo.Customer;
import com.wang.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerMapper customerMapper;

    @Override
    public List<Customer> queryAll() {
        return customerMapper.queryAll();
    }

    @Override
    public int insertCustomer(Customer customer) {
        return customerMapper.insertCustomer(customer);
    }

    @Override
    public int updateCustomer(Customer customer) {
        return customerMapper.updateCustomer(customer);
    }

    @Override
    public int deleteCustomer(int id) {
        return customerMapper.deleteCustomer(id);
    }
}
