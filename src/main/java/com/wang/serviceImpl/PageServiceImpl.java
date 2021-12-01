package com.wang.serviceImpl;

import com.wang.dao.PageMapper;
import com.wang.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PageServiceImpl implements PageService {

    @Autowired
    PageMapper pageMapper;
    @Override
    public List queryAll() {
        return pageMapper.queryAll();
    }

    @Override
    public List queryPage(int pageNum, int pageBig) {
        return pageMapper.queryPage(pageNum,pageBig);
    }
}
