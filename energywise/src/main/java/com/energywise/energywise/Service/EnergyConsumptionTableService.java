package com.energywise.energywise.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.energywise.energywise.Entity.EnergyConsumptionTableEntity;
import com.energywise.energywise.Repository.EnergyConsumptionTableRepository;

@Service
public class EnergyConsumptionTableService {

    @Autowired
    private EnergyConsumptionTableRepository ectRepo;

    public List<EnergyConsumptionTableEntity> processAndSaveCsvFile(MultipartFile file, Integer user_id)
            throws Exception {
        List<EnergyConsumptionTableEntity> tableEntries = parseCsvFile(file, user_id);

        return ectRepo.saveAll(tableEntries);
    }

    private List<EnergyConsumptionTableEntity> parseCsvFile(MultipartFile file, Integer user_id) throws Exception {
        List<EnergyConsumptionTableEntity> tableEntries = new ArrayList<>();

        try (BufferedReader fileReader = new BufferedReader(
                new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8));
                CSVParser csvParser = new CSVParser(fileReader,
                        CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())) {

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                EnergyConsumptionTableEntity entry = new EnergyConsumptionTableEntity();
                entry.setEctMonth(csvRecord.get("Month"));
                entry.setEctConsumption(Float.parseFloat(csvRecord.get("Consumption")));
                entry.setEctPrice(Float.parseFloat(csvRecord.get("Price")));
                entry.setUserId(user_id);
                tableEntries.add(entry);
            }
        }
        return tableEntries;
    }

    public List<EnergyConsumptionTableEntity> getEntriesByUserId(Integer user_id) {
        return ectRepo.findByUserId(user_id);
    }
}
