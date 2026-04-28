package com.academic_project.event_ticket_booking_system.repository;

import com.academic_project.event_ticket_booking_system.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepo extends JpaRepository<Users,Long> {

    Optional<Users> findByEmail(String email);
}
