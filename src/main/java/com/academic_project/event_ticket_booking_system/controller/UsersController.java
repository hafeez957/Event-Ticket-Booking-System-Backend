package com.academic_project.event_ticket_booking_system.controller;

import com.academic_project.event_ticket_booking_system.model.Users;
import com.academic_project.event_ticket_booking_system.service.UsersService;
import com.academic_project.event_ticket_booking_system.structure.ResponseStructure;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UsersController {

    private final UsersService usersService;

    @PostMapping
    public ResponseEntity<ResponseStructure<Users>> create(@RequestBody Users users){
        Users users1=usersService.create(users);
        ResponseStructure<Users> rs=new ResponseStructure<>();
        rs.setMessage("Data inserted successfully");
        rs.setData(users);
        rs.setStatusCode(HttpStatus.CREATED.value());

        return new ResponseEntity<>(rs,HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<ResponseStructure<List<Users>>> findAll(){
        List<Users> users=usersService.findAll();
        ResponseStructure<List<Users>> rs=new ResponseStructure<>();
        rs.setMessage("Data inserted successfully");
        rs.setData(users);
        rs.setStatusCode(HttpStatus.FOUND.value());

        return new ResponseEntity<>(rs,HttpStatus.FOUND);
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseStructure<Users>> login(@RequestBody Users users){
        Users users1=usersService.login(users);
        ResponseStructure<Users> rs=new ResponseStructure<>();
        rs.setMessage("Login successful");
        rs.setData(users);
        rs.setStatusCode(HttpStatus.CREATED.value());

        return new ResponseEntity<>(rs,HttpStatus.CREATED);
    }
}

