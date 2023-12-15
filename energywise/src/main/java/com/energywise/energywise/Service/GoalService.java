package com.energywise.energywise.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energywise.energywise.Entity.GoalEntity;
import com.energywise.energywise.Repository.GoalRepository;


@Service
public class GoalService {

    @Autowired
    GoalRepository gRepo;

    // C
    public GoalEntity insertGoal(GoalEntity goal) {
        return gRepo.save(goal);
    }

    // R
    public List<GoalEntity> getAllGoals() {
        return gRepo.findAll();
    }

    // U
    @SuppressWarnings("finally")
    public GoalEntity updateGoal(int goal_id, GoalEntity newGoalDetails) {
        GoalEntity goal = new GoalEntity();

        try {
            goal = gRepo.findById(goal_id).get();
            goal.setGoalName(newGoalDetails.getGoalName());
            goal.setTargetValue(newGoalDetails.getTargetValue());
            goal.setCompletionDate(newGoalDetails.getCompletionDate());

        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Goal " + goal_id + " not found!");
        } finally {
            return gRepo.save(goal);
        }
    }

    // D
    public String deleteGoal(int goal_id) {
        String msg = "";

        if (gRepo.findById(goal_id) != null) {
            gRepo.deleteById(goal_id);
            msg = "Goal " + goal_id + " is deleted!";
        } else {
            msg = "Goal " + goal_id + " not found!";
        }

        return msg;
    }
}
