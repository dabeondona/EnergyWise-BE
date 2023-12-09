package com.energywise.energywise.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energywise.energywise.Entity.BillEntity;
import com.energywise.energywise.Repository.BillRepository;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepo;

    public BillEntity createBill(BillEntity bill) {
        return billRepo.save(bill);
    }

    public List<BillEntity> getAllBills() {
        return billRepo.findAll();
    }

    public BillEntity updateBill(int billId, BillEntity newBillDetails) {
        Optional<BillEntity> optionalBill = billRepo.findById(billId);

        if (optionalBill.isPresent()) {
            BillEntity bill = optionalBill.get();

            return billRepo.save(bill);
        } else {
            throw new NoSuchElementException("Bill with ID " + billId + " not found!");
        }
    }

    public String deleteBill(int billId) {
        Optional<BillEntity> optionalBill = billRepo.findById(billId);

        if (optionalBill.isPresent()) {
            billRepo.deleteById(billId);
            return "Bill with ID " + billId + " has been deleted.";
        } else {
            throw new NoSuchElementException("Bill with ID " + billId + " not found!");
        }
    }
}
