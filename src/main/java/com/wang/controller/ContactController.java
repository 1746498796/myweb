package com.wang.controller;

import com.wang.pojo.Contact;
import com.wang.serviceImpl.ContactServiceImpl;
import com.wang.uitls.ImgFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.nio.channels.MulticastChannel;

@Controller
@PropertySource("application.properties")
public class ContactController {

    @Autowired
    private ImgFile imgFile;
    @Autowired
    ContactServiceImpl contactService;

    @GetMapping("/user/contactlistHtml")
    public String contactlistHtml(Model model){
        Contact contact = contactService.queryAll();
        model.addAttribute("contact",contact);
        return "comm/contactlist";
    }
    @GetMapping("/user/updateContactHtml")
    public String updateContactHtml(Model model){
        Contact contact = contactService.queryAll();
        model.addAttribute("contact",contact);
        return "comm/updateContact";
    }

    @PostMapping("/user/updateContact")
    public String updateContact(MultipartFile file,Contact contact, Model model){
        if (file.getOriginalFilename().isEmpty()){
            contactService.updateContact(contact);
        }else {
            String upload = imgFile.upload(file);
            contact.setWeCat(upload);
            contactService.updateContact(contact);
        }

        return "redirect:/user/contactlistHtml";
    }

}
