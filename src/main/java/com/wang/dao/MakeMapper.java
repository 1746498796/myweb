package com.wang.dao;

import com.wang.pojo.Make;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface MakeMapper {

    List<Make> queryAll();

    int updateByID(Make make);

    Make queryByID(@Param("id") int id);
}
