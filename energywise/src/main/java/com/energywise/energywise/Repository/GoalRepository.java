package com.energywise.energywise.Repository;

import com.energywise.energywise.Entity.GoalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalRepository extends JpaRepository<GoalEntity, Integer> {
}
