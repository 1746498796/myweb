package com.wang.dao;

import com.wang.pojo.Index1;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface Index1Mapper {

    Index1 queryAll();
    int updateAll(Index1 index1);
    int updatemp4name(@Param("mp4name") String mp4name);
    String querymp4name();
}
