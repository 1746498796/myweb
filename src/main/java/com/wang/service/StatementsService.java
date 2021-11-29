package com.wang.service;

import com.wang.pojo.Statements;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StatementsService {

    List<Statements> queryAll();

    Statements queryByID( int id);

    int insertOne(Statements statements);

    int upDateByID(Statements statements);

    int deleteByID( int id);

}
