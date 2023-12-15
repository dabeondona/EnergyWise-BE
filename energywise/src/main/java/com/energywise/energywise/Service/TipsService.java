package com.energywise.energywise.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energywise.energywise.Entity.TipsEntity;
import com.energywise.energywise.Repository.TipsRepository;

@Service
public class TipsService {

    @Autowired
    TipsRepository tRepo;

    // C
    public TipsEntity insertTips(TipsEntity tip) {
        return tRepo.save(tip);
    }

    // R
    public List<TipsEntity> getAllTips() {
        return tRepo.findAll();
    }

    // U
    @SuppressWarnings("finally")
    public TipsEntity updateRate(int tip_id, TipsEntity newTipsDetails) {
        TipsEntity tip = new TipsEntity();

        try {
            tip = tRepo.findById(tip_id).get();
            tip.setTitle(newTipsDetails.getTitle());
            tip.setContent(newTipsDetails.getContent());
            tip.setDate(newTipsDetails.getDate());
            
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Tip " + tip_id + " not found!");
        } finally {
            return tRepo.save(tip);
        }
    }

    // D
    public String deleteTips(int tip_id) {
        String msg = "";

        if (tRepo.findById(tip_id) != null) {
            tRepo.deleteById(tip_id);
            msg = "Tip " + tip_id + " is deleted!";
        } else {
            msg = "Tip " + tip_id + " not found!";
        }

        return msg;
    }
}
