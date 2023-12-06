package com.energywise.energywise.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.energywise.energywise.Entity.RateEntity;

public interface RateRepository extends JpaRepository<RateEntity, Integer> {

}
