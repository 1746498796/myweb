package com.wang.serviceImpl;

import com.wang.dao.ComprofileMapper;
import com.wang.pojo.Comprofile;
import com.wang.service.ComprofileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComprofileServiceImpl implements ComprofileService {
    @Autowired
    ComprofileMapper comprofileMapper;
    @Override
    public Comprofile queryAll() {
        return comprofileMapper.queryAll();
    }

    @Override
    public int updateByID(Comprofile comprofile) {
        return comprofileMapper.updateByID(comprofile);
    }
}
