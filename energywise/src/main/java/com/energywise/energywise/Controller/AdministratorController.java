package com.energywise.energywise.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/login")
    public ResponseEntity<?> loginAdmin(@RequestBody LoginDto loginDto) {
        boolean isValidAdmin = adminService.validateAdmin(loginDto.getUsername(), loginDto.getPassword());

        if (isValidAdmin) {
            return ResponseEntity.ok().body("Admin authenticated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    @PostMapping("/insertAdmin")
    public ResponseEntity<?> insertAdmin(@RequestBody AdminRegistrationDto registrationDto) {
        AdministratorEntity admin = new AdministratorEntity();
        admin.setUsername(registrationDto.getUsername());
        admin.setPassword(registrationDto.getPassword());
        admin.setFirstname(registrationDto.getFirstname());
        admin.setLastname(registrationDto.getLastname());

        AdministratorEntity savedAdmin = adminService.insertAdmin(admin);

        AdminDto adminDto = mapToAdminDto(savedAdmin);

        return new ResponseEntity<>(adminDto, HttpStatus.CREATED);
    }

    @GetMapping("/getAdminDetails")
    public ResponseEntity<?> getAdminDetails(@RequestParam String username) {
        AdministratorEntity admin = adminService.findAdminByUsername(username);
        if (admin != null) {
            AdminDto adminDto = mapToAdminDto(admin);
            return ResponseEntity.ok(adminDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Admin not found");
        }
    }

    private AdminDto mapToAdminDto(AdministratorEntity admin) {
        AdminDto adminDto = new AdminDto();
        adminDto.setUsername(admin.getUsername());
        adminDto.setFirstname(admin.getFirstname());
        adminDto.setLastname(admin.getLastname());
        return adminDto;
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
