package com.energywise.energywise.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energywise.energywise.Entity.AdministratorEntity;
import com.energywise.energywise.Repository.AdministratorRepository;

@Service
public class AdministratorService {
    
    @Autowired
    AdministratorRepository adminRepo;

    // C - TO BE REMOVED
    public AdministratorEntity insertAdmin(AdministratorEntity admin) {
        return adminRepo.save(admin);
    }

    // R - TO BE REMOVED
    public List<AdministratorEntity> getAllAdmins() {
        return adminRepo.findAll();
    }

    // U 
    @SuppressWarnings("finally")
    public AdministratorEntity updateAdmin(int admin_id, AdministratorEntity newAdminDetails) {
        AdministratorEntity admin = new AdministratorEntity();

        try {
            admin = adminRepo.findById(admin_id).get();
            admin.setUsername(newAdminDetails.getUsername());
            admin.setFirstname(newAdminDetails.getFirstname());
            admin.setLastname(newAdminDetails.getLastname());
            admin.setPassword(newAdminDetails.getPassword());
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Admin " + admin_id + " not found!");
        } finally {
            return adminRepo.save(admin);
        }
    }

    // D - TO BE DELETED
    public String deleteAdmin(int admin_id) {
        String msg = "";

        if(adminRepo.findById(admin_id) != null) {
            adminRepo.deleteById(admin_id);
            msg = "Admin " + admin_id + " is deleted!";
        } else {
            msg = "Admin " + admin_id + " not found!";
        }

        return msg;
    }

}
