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

import com.energywise.energywise.Entity.AdministratorEntity;
import com.energywise.energywise.Service.AdministratorService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/admin")
public class AdministratorController {

    @Autowired
    AdministratorService adminService;

    @GetMapping("/print")
    public String printHello() {
        return "Hello, Mic Test!";
    }

    @PostMapping("/insertAdmin")
    public AdministratorEntity insertAdmin(@RequestBody AdministratorEntity admin) {
        return adminService.insertAdmin(admin);
    }

    @GetMapping("/getAllAdmins")
    public List<AdministratorEntity> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @PutMapping("/updateAdmin")
    public AdministratorEntity updateAdmin(@RequestParam int admin_id,
            @RequestBody AdministratorEntity newAdminDetails) {
        return adminService.updateAdmin(admin_id, newAdminDetails);
    }

    @DeleteMapping("/deleteAdmin/{admin_id}")
    public String deleteAdmin(@PathVariable int admin_id) {
        return adminService.deleteAdmin(admin_id);
    }
}
