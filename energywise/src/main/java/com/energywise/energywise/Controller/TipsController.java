package com.energywise.energywise.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
    public String printHello(){
        return "Hello , Mic Test!";
    }

    @PostMapping("/insertTips")
    public TipsEntity insertTips(@RequestBody TipsEntity tip){
        return tService.insertTips(tip);
    }
    @GetMapping("/getAllTips")
    public List<TipsEntity> getAllTips(){
        return tService.getAllTips();
    }
    @PutMapping("/updateTips/{tip_id}")
    public TipsEntity updateTips(@RequestParam int tip_id, @RequestBody TipsEntity newTipsDetails){
        return tService.updateTips(tip_id, newTipsDetails);
    }
}
