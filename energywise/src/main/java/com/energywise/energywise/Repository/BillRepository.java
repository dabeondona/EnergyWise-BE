package com.energywise.energywise.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.energywise.energywise.Entity.BillEntity;

public interface BillRepository extends JpaRepository<BillEntity, Integer> {

}