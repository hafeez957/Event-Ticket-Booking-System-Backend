package com.academic_project.event_ticket_booking_system.exceptions;

import com.academic_project.event_ticket_booking_system.model.Events;
import com.academic_project.event_ticket_booking_system.model.Users;
import com.academic_project.event_ticket_booking_system.structure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<ResponseStructure<Events>> idNotFoundExceptionHandler(IdNotFoundException e){
        ResponseStructure<Events> rs=new ResponseStructure<>();
        rs.setMessage(e.getMessage());
        rs.setData(null);
        rs.setStatusCode(HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(rs,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullFieldException.class)
    public ResponseEntity<ResponseStructure<Users>> idNotFoundExceptionHandler(NullFieldException e){
        ResponseStructure<Users> rs=new ResponseStructure<>();
        rs.setMessage(e.getMessage());
        rs.setData(null);
        rs.setStatusCode(HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(rs,HttpStatus.BAD_REQUEST);
    }


}

