package com.wang.service;

import com.wang.pojo.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductService {
    List<Product> queryALl();

    int updateProduct(Product product);
    Product queryByID( int id);

    int insertProduct(Product product);

    int deleteProduct(int id);
}
