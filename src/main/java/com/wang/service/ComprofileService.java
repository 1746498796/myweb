package com.wang.service;

import com.wang.pojo.Comprofile;
import org.apache.ibatis.annotations.Param;

public interface ComprofileService {

    Comprofile queryAll();
    int updateByID(Comprofile comprofile);
}
