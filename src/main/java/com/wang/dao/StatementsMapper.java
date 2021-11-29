package com.wang.dao;

import com.wang.pojo.Statements;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface StatementsMapper {

    List<Statements> queryAll();

    Statements queryByID(@Param("id") int id);

    int insertOne(Statements statements);

    int upDateByID(Statements statements);

    int deleteByID(@Param("id") int id);

}
