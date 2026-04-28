package com.academic_project.event_ticket_booking_system.service;

import com.academic_project.event_ticket_booking_system.model.Users;

import java.util.List;

public interface UsersService {
    Users create(Users users);

    List<Users> findAll();

    Users login(Users users);
}

