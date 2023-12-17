package com.energywise.energywise.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.energywise.energywise.Entity.EnergyConsumptionTableEntity;

public interface EnergyConsumptionTableRepository extends JpaRepository<EnergyConsumptionTableEntity, Integer> {
    List<EnergyConsumptionTableEntity> findByUserId(int user_id);
}
