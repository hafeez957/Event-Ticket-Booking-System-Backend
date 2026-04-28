package com.academic_project.event_ticket_booking_system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import javax.annotation.processing.Generated;
import java.util.Date;

@Data
@Entity
public class Events {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long event_number;
    private String event_name;
    private String co_name;
    private Long co_number;
    private double fee;
    private String venue;
    private Date event_date;
}
