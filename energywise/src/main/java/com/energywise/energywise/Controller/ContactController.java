package com.energywise.energywise.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @PutMapping("/updateContact")
    public ContactEntity updateContact(@RequestParam int contact_id, @RequestBody ContactEntity newContactDetails) {
        return cService.updateContact(contact_id, newContactDetails);
    }

    @DeleteMapping("/deleteContact/{contact_id}")
    public String deleteContact(@PathVariable int contact_id) {
        return cService.deleteContact(contact_id);
    }

}
