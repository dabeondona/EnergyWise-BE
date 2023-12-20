package com.energywise.energywise.Entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblgoal")

public class GoalEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goal_id")
    private int goal_id;

    @Column(name = "goalName")
    private String goalName;

    @Column(name = "targetValue")
    private double targetValue;

    @Column(name = "completionDate")
    private Date completionDate;

    @Column(name = "isDeleted")
    private boolean isDeleted;

    public GoalEntity() {
        super();
    }


    public GoalEntity(int goal_id, String goalName, double targetValue, Date completionDate, boolean isDeleted) {
        this.goal_id = goal_id;
        this.goalName = goalName;
        this.targetValue = targetValue;
        this.completionDate = completionDate;
        this.isDeleted = isDeleted;
    }

    public int getId() {
        return goal_id;
    }

    public void setId(int goal_id) {
        this.goal_id = goal_id;
    }

    public String getGoalName() {
        return goalName;
    }

    public void setGoalName(String goalName) {
        this.goalName = goalName;
    }

    public double getTargetValue() {
        return targetValue;
    }

    public void setTargetValue(double targetValue) {
        this.targetValue = targetValue;
    }

    public Date getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

   

}
