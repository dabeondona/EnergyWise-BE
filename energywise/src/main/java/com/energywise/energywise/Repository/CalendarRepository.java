package com.energywise.energywise.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.energywise.energywise.Entity.CalendarEntity;

public interface CalendarRepository extends JpaRepository<CalendarEntity, Integer> {

}