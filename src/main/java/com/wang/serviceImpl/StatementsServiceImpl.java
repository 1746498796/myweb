package com.wang.serviceImpl;

import com.wang.dao.StatementsMapper;
import com.wang.pojo.Statements;
import com.wang.service.StatementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StatementsServiceImpl implements StatementsService {

    @Autowired
    StatementsMapper statementsMapper;

    @Override
    public List<Statements> queryAll() {
        return statementsMapper.queryAll();
    }

    @Override
    public Statements queryByID(int id) {
        return statementsMapper.queryByID(id);
    }

    @Override
    public int insertOne(Statements statements) {
        return statementsMapper.insertOne(statements);
    }

    @Override
    public int upDateByID(Statements statements) {
        return statementsMapper.upDateByID(statements);
    }

    @Override
    public int deleteByID(int id) {
        return statementsMapper.deleteByID(id);
    }
}
