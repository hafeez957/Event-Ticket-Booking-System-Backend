package com.academic_project.event_ticket_booking_system.service;

import com.academic_project.event_ticket_booking_system.exceptions.IdNotFoundException;
import com.academic_project.event_ticket_booking_system.model.Events;
import com.academic_project.event_ticket_booking_system.repository.EventRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EventServiceImpl implements EventService{

    private final EventRepo eventRepo;


    @Override
    public Events create(Events events) {
        return eventRepo.save(events);
    }

    @Override
    public List<Events> findAll() {
        return eventRepo.findAll();
    }

    @Override
    public Events update(Events events) {
        return eventRepo.save(events);
    }

    @Override
    public String delete(Long id){
        Optional<Events> eve=eventRepo.findById(id);
        if(eve.isPresent()){
            eventRepo.deleteById(id);
            return "data is deleted";
        }else{
            throw new IdNotFoundException("Invalid id");
        }


    }

    @Override
    public Optional<Events> find(Long id){
        Optional<Events> events=  eventRepo.findById(id);
        if(events.isPresent()){
            return events;
        }else{
            throw new IdNotFoundException("Invalid Id");
        }
    }
}

