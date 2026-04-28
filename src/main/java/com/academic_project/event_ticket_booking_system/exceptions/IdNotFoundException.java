package com.academic_project.event_ticket_booking_system.exceptions;

public class IdNotFoundException extends RuntimeException {
    public IdNotFoundException(String invalidId) {
        super(invalidId);
    }
}

