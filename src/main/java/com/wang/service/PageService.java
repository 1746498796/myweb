package com.wang.service;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PageService {
    List queryAll();

    List queryPage(int pageNum,int pageBig);
}
