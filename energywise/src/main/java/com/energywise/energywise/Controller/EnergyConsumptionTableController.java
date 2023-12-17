package com.energywise.energywise.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.energywise.energywise.Entity.EnergyConsumptionTableEntity;
import com.energywise.energywise.Service.EnergyConsumptionTableService;

@RestController
@RequestMapping("/energyTable")
public class EnergyConsumptionTableController {

    @Autowired
    private EnergyConsumptionTableService ectService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadEnergyConsumptionData(
            @RequestParam("file") MultipartFile file,
            @RequestParam("user_id") Integer userId) {

        try {
            List<EnergyConsumptionTableEntity> savedEntries = ectService.processAndSaveCsvFile(file, userId);
            if (savedEntries.isEmpty()) {
                return ResponseEntity.badRequest().body("No entries were saved. Please check the CSV file format.");
            }
            return ResponseEntity.ok("Energy consumption data saved successfully for User ID: " + userId);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error processing CSV file: " + e.getMessage());
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getEnergyConsumptionEntriesByUser(@PathVariable Integer user_id) {
        try {
            List<EnergyConsumptionTableEntity> entries = ectService.getEntriesByUserId(user_id);
            return ResponseEntity.ok(entries);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error retrieving entries: " + e.getMessage());
        }
    }
}
