package com.energywise.energywise.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.energywise.energywise.Entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    
}
