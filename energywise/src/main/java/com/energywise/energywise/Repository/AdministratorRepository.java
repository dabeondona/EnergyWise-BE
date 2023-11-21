package com.energywise.energywise.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.energywise.energywise.Entity.AdministratorEntity;

public interface AdministratorRepository extends JpaRepository<AdministratorEntity, Integer> {
    
}