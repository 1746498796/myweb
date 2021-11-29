package com.wang.dao;

import com.wang.pojo.Contact;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ContactMapper {

    Contact queryAll();

    int updateContact(Contact contact);
}
