package com.energywise.energywise.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.energywise.energywise.Entity.TipsEntity;

public interface TipsRepository extends JpaRepository<TipsEntity, Integer> {
    
}
