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
    TipsRepository tipsRepo;

    // C - TO BE REMOVED
    public TipsEntity insertTips(TipsEntity tip) {
        return tipsRepo.save(tip);
    }

    // R - TO BE REMOVED
    public List<TipsEntity> getAllTips() {
        return tipsRepo.findAll();
    }

    // U
    @SuppressWarnings("finally")
    public TipsEntity updateTips(int tip_id, TipsEntity newTipsDetails) {
        TipsEntity tip = new TipsEntity();

        try {
            tip = tipsRepo.findById(tip_id).get();
            tip.setTitle(newTipsDetails.getTitle());
            tip.setContent(newTipsDetails.getContent());
            tip.setDate(newTipsDetails.getDate());
            tip.setDeleted(newTipsDetails.isDeleted());
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Admin " + tip_id + " not found!");
        } finally {
            return tipsRepo.save(tip);
        }
    }

    // D - TO BE DELETED
    public String deleteTips(int tip_id) {
        String msg = "";

        if (tipsRepo.findById(tip_id) != null) {
            tipsRepo.deleteById(tip_id);
            msg = "Admin " + tip_id + " is deleted!";
        } else {
            msg = "Admin " + tip_id + " not found!";
        }

        return msg;
    }
}
