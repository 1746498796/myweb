package com.wang.serviceImpl;

import com.wang.dao.Index1Mapper;
import com.wang.pojo.Index1;
import com.wang.service.Index1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Index1ServiceImpl implements Index1Service {

    @Autowired
    private Index1Mapper index1Mapper;

    public void setIndex1Mapper(Index1Mapper index1Mapper) {
        this.index1Mapper = index1Mapper;
    }

    @Override
    public Index1 queryAll() {
        return index1Mapper.queryAll();
    }

    @Override
    public int updateAll(Index1 index1) {
        return index1Mapper.updateAll(index1);
    }

    @Override
    public int updatemp4name(String mp4name) {
        return index1Mapper.updatemp4name(mp4name);
    }

    @Override
    public String querymp4name() {
        return index1Mapper.querymp4name();
    }
}
