package com.wang.dao;

import com.wang.pojo.Comprofile;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ComprofileMapper {

    Comprofile queryAll();
    int updateByID(Comprofile comprofile);

}
