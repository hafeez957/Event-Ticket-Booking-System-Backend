package com.academic_project.event_ticket_booking_system.structure;

import lombok.Data;

@Data
public class ResponseStructure<T> {

    private T data;
    private String message;
    private Integer statusCode;
}
