package com.wang.serviceImpl;

import com.wang.dao.ContactMapper;
import com.wang.pojo.Contact;
import com.wang.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactMapper contactMapper;
    @Override
    public Contact queryAll() {
        return contactMapper.queryAll();
    }

    @Override
    public int updateContact(Contact contact) {
        return contactMapper.updateContact(contact);
    }
}
