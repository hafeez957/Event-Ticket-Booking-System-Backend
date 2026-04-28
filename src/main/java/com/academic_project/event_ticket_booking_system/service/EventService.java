package com.academic_project.event_ticket_booking_system.service;

import com.academic_project.event_ticket_booking_system.exceptions.IdNotFoundException;
import com.academic_project.event_ticket_booking_system.model.Events;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EventService {
    Events create(Events events);

    List<Events> findAll();

    Events update(Events events);

    String delete(Long id) ;

    Optional<Events> find(Long id);
}

