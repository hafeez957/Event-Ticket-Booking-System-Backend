package com.academic_project.event_ticket_booking_system.controller;

import com.academic_project.event_ticket_booking_system.model.Events;
import com.academic_project.event_ticket_booking_system.service.EventService;
import com.academic_project.event_ticket_booking_system.structure.ResponseStructure;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @PostMapping
    public ResponseEntity<ResponseStructure<Events>> create(@RequestBody Events events){
        eventService.create(events);
        ResponseStructure<Events> rs=new ResponseStructure<>();
        rs.setMessage("Data inserted successfully");
        rs.setData(events);
        rs.setStatusCode(HttpStatus.CREATED.value());

        return new ResponseEntity<>(rs,HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<ResponseStructure<List<Events>>> findAll(){
        List<Events> events=eventService.findAll();
        ResponseStructure<List<Events>> rs=new ResponseStructure<>();
        rs.setMessage("Data inserted successfully");
        rs.setData(events);
        rs.setStatusCode(HttpStatus.FOUND.value());

        return new ResponseEntity<>(rs,HttpStatus.FOUND);
    }

    @PatchMapping
    public ResponseEntity<ResponseStructure<Events>> update(@RequestBody Events events){

//         eve=eventService.find(events.getId());

        eventService.update(events);
        ResponseStructure<Events> rs=new ResponseStructure<>();
        rs.setMessage("Data updated or inserted successfully");
        rs.setData(events);
        rs.setStatusCode(HttpStatus.CREATED.value());

        return new ResponseEntity<>(rs,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseStructure<Events>> delete(@PathVariable Long id){
        eventService.delete(id);
        ResponseStructure<Events> rs=new ResponseStructure<>();
        rs.setMessage("Data Deleted successfully");
        rs.setData(null);
        rs.setStatusCode(HttpStatus.OK.value());

        return new ResponseEntity<>(rs,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseStructure<Events>> find(@PathVariable Long id){
        Optional<Events> eve=eventService.find(id);
        ResponseStructure<Events> rs=new ResponseStructure<>();
        rs.setMessage("Data inserted successfully");
        rs.setData(eve.get());
        rs.setStatusCode(HttpStatus.FOUND.value());

        return new ResponseEntity<>(rs,HttpStatus.FOUND);
    }


}

