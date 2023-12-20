package com.energywise.energywise.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energywise.energywise.Entity.RateEntity;
import com.energywise.energywise.Repository.RateRepository;

@Service
public class RateService {

    @Autowired
    RateRepository rRepo;

    // C
    public RateEntity insertRate(RateEntity rate) {
        return rRepo.save(rate);
    }

    // R
    public List<RateEntity> getAllRates() {
        return rRepo.findAll();
    }

    // U
    @SuppressWarnings("finally")
    public RateEntity updateRate(int rate_id, RateEntity newRateDetails) {
        RateEntity rate = new RateEntity();

        try {
            rate = rRepo.findById(rate_id).get();
            rate.setMonth(newRateDetails.getMonth());
            rate.setPrice(newRateDetails.getPrice());
            rate.setPrevious_month(newRateDetails.getPrevious_month());
            rate.setPrevious_price(newRateDetails.getPrevious_price());
            rate.setPrice_luzon(newRateDetails.getPrice_luzon());
            rate.setPrice_mindanao(newRateDetails.getPrice_mindanao());
            rate.setDeleted(newRateDetails.isDeleted());
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Admin " + rate_id + " not found!");
        } finally {
            return rRepo.save(rate);
        }
    }

    // D
    public String deleteRate(int rate_id) {
        String msg = "";

        if (rRepo.findById(rate_id) != null) {
            rRepo.deleteById(rate_id);
            msg = "Rate " + rate_id + " is deleted!";
        } else {
            msg = "Rate " + rate_id + " not found!";
        }

        return msg;
    }
}
