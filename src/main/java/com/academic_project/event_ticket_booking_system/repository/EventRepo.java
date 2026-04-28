package com.academic_project.event_ticket_booking_system.repository;

import com.academic_project.event_ticket_booking_system.model.Events;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepo extends JpaRepository<Events,Long> {
}
