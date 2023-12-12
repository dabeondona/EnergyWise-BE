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
    GoalRepository goalRepo;

    // C - TO BE REMOVED
    public GoalEntity insertGoal(GoalEntity goal) {
        return goalRepo.save(goal);
    }

    // R - TO BE REMOVED
    public List<GoalEntity> getAllGoals() {
        return goalRepo.findAll();
    }

    // U
    @SuppressWarnings("finally")
    public GoalEntity updateGoals(int goal_id, GoalEntity newGoalDetails) {
        GoalEntity goal = new GoalEntity();

        try {
            goal = goalRepo.findById(goal_id).get();
            goal.setGoalName(newGoalDetails.getGoalName());
            goal.setTargetValue(newGoalDetails.getTargetValue());
            goal.setCompletionDate(newGoalDetails.getCompletionDate());
            goal.setDeleted(newGoalDetails.isDeleted());
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Admin " + goal_id + " not found!");
        } finally {
            return goalRepo.save(goal);
        }
    }

    // D - TO BE DELETED
    public String deleteGoal(int goal_id) {
        String msg = "";

        if (goalRepo.findById(goal_id) != null) {
            goalRepo.deleteById(goal_id);
            msg = "Admin " + goal_id + " is deleted!";
        } else {
            msg = "Admin " + goal_id + " not found!";
        }

        return msg;
    }
}
