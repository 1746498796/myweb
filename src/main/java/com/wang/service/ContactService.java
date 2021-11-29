package com.wang.service;

import com.wang.pojo.Contact;

public interface ContactService {

    Contact queryAll();

    int updateContact(Contact contact);
}
