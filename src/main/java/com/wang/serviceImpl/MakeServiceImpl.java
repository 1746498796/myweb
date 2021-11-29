package com.wang.serviceImpl;

import com.wang.dao.MakeMapper;
import com.wang.pojo.Make;
import com.wang.service.MakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MakeServiceImpl implements MakeService {
    @Autowired
    MakeMapper makeMapper;

    @Override
    public List<Make> queryAll() {
        return makeMapper.queryAll();
    }

    @Override
    public int updateByID(Make make) {
        return makeMapper.updateByID(make);
    }

    @Override
    public Make queryByID(int id) {
        return makeMapper.queryByID(id);
    }
}
