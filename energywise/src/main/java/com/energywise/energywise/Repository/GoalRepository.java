package com.energywise.energywise.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.energywise.energywise.Entity.GoalEntity;

public interface GoalRepository extends JpaRepository<GoalEntity, Integer> {
    
}
