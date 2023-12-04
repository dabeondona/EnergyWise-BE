package com.energywise.energywise.Service;

import java.util.List;
import java.util.NoSuchElementException;

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

    // U
    @SuppressWarnings("finally")
    public ContactEntity updateContact(int contact_id, ContactEntity newContactDetails) {
        ContactEntity contact = new ContactEntity();

        try {
            contact = cRepo.findById(contact_id).get();
            contact.setContact_name(newContactDetails.getContact_name());
            contact.setContact_email(newContactDetails.getContact_email());
            contact.setContact_message(newContactDetails.getContact_message());
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Contact " + contact_id + " not found!");
        } finally {
            return cRepo.save(contact);
        }
    }

    // D
    public String deleteContact(int contact_id) {
        String msg = "";

        if (cRepo.findById(contact_id) != null) {
            cRepo.deleteById(contact_id);
            msg = "Contact " + contact_id + " is deleted!";
        } else {
            msg = "Contact " + contact_id + " not found!";
        }
        return msg;
    }
}
