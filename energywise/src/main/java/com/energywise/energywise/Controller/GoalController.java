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

import com.energywise.energywise.Entity.GoalEntity;
import com.energywise.energywise.Service.GoalService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/goal")
public class GoalController {

    @Autowired
    GoalService gService;

    @GetMapping("/print")
    public String printHello() {
        return "Hello, Mic Test!";
    }

    @PostMapping("/insertGoal")
    public GoalEntity insertGoal(@RequestBody GoalEntity goal) {
        return gService.insertGoal(goal);
    }

    @GetMapping("/getAllGoals")
    public List<GoalEntity> getAllGoals() {
        return gService.getAllGoals();
    }

    @PutMapping("/updateGoal")
    public GoalEntity updateGoal(@RequestParam int goal_id, @RequestBody GoalEntity newGoalDetails) {
        return gService.updateGoal(goal_id, newGoalDetails);
    }

    @DeleteMapping("/deleteGoal/{goal_id}")
    public String deleteGoal(@PathVariable int goal_id) {
        return gService.deleteGoal(goal_id);
    }
}
