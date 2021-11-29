package com.wang.serviceImpl;

import com.wang.dao.ProductMapper;
import com.wang.pojo.Product;
import com.wang.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;
    @Override
    public List<Product> queryALl() {
        return productMapper.queryALl();
    }

    @Override
    public int updateProduct(Product product) {
        return productMapper.updateProduct(product);
    }

    @Override
    public Product queryByID(int id) {
        return productMapper.queryByID(id);
    }

    @Override
    public int insertProduct(Product product) {
        return productMapper.insertProduct(product);
    }

    @Override
    public int deleteProduct(int id) {
        return productMapper.deleteProduct(id);
    }


}
