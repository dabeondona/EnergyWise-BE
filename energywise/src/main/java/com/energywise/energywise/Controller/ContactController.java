package com.energywise.energywise.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.energywise.energywise.Entity.ContactEntity;
import com.energywise.energywise.Service.ContactService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    ContactService cService;

    @GetMapping("/print")
    public String printHello() {
        return "Hello, Mic Test!";
    }

    @PostMapping("/insertMsg")
    public ContactEntity insertMsg(@RequestBody ContactEntity msg) {
        return cService.insertMessage(msg);
    }

    @GetMapping("/getAllMsgs")
    public List<ContactEntity> getAllMsgs() {
        return cService.getAllMsgs();
    }

}
