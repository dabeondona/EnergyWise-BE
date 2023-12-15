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

import com.energywise.energywise.Entity.TipsEntity;
import com.energywise.energywise.Service.TipsService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/tips")
public class TipsController {

    @Autowired
    TipsService tService;

    @GetMapping("/print")
    public String printHello() {
        return "Hello, Mic Test!";
    }

    @PostMapping("/insertTips")
    public TipsEntity insertTips(@RequestBody TipsEntity tips) {
        return tService.insertTips(tips);
    }

    @GetMapping("/getAllTips")
    public List<TipsEntity> getAllTips() {
        return tService.getAllTips();
    }

    @PutMapping("/updateTips")
    public TipsEntity updateRate(@RequestParam int tip_id, @RequestBody TipsEntity newTipsDetails) {
        return tService.updateRate(tip_id, newTipsDetails);
    }

    @DeleteMapping("/deleteTips/{tips_id}")
    public String deleteTips(@PathVariable int tip_id) {
        return tService.deleteTips(tip_id);
    }
}
