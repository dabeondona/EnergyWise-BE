package com.energywise.energywise.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.energywise.energywise.Entity.ContactEntity;

public interface ContactRepository extends JpaRepository<ContactEntity, Integer> {

}
