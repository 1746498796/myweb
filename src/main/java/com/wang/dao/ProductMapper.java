package com.wang.dao;

import com.wang.pojo.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProductMapper {

    List<Product> queryALl();

    int updateProduct(Product product);

    Product queryByID(@Param("id") int id);

    int insertProduct(Product product);
    int deleteProduct(@Param("id") int id);
}
