package com.energywise.energywise.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energywise.energywise.Entity.ContactEntity;
import com.energywise.energywise.Repository.ContactRepository;

@Service
public class ContactService {

    @Autowired
    ContactRepository cRepo;

    // C
    public ContactEntity insertMessage(ContactEntity msg) {
        return cRepo.save(msg);
    }

    // R
    public List<ContactEntity> getAllMsgs() {
        return cRepo.findAll();
    }
}
