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

import com.energywise.energywise.Entity.RateEntity;
import com.energywise.energywise.Service.RateService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/rate")
public class RateController {

    @Autowired
    RateService rService;

    @GetMapping("/print")
    public String printHello() {
        return "Hello, Mic Test!";
    }

    @PostMapping("/insertRate")
    public RateEntity insertRate(@RequestBody RateEntity rate) {
        return rService.insertRate(rate);
    }

    @GetMapping("/getAllRates")
    public List<RateEntity> getAllRates() {
        return rService.getAllRates();
    }

    @PutMapping("/updateRate")
    public RateEntity updateRate(@RequestParam int rate_id, @RequestBody RateEntity newRateDetails) {
        return rService.updateRate(rate_id, newRateDetails);
    }

    @DeleteMapping("/deleteRate/{rate_id}")
    public String deleteRate(@PathVariable int rate_id) {
        return rService.deleteRate(rate_id);
    }
}
