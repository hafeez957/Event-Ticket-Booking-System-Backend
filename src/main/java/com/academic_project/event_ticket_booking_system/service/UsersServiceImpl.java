package com.academic_project.event_ticket_booking_system.service;

import com.academic_project.event_ticket_booking_system.exceptions.InvalidCredentialException;
import com.academic_project.event_ticket_booking_system.exceptions.NullFieldException;
import com.academic_project.event_ticket_booking_system.model.Users;
import com.academic_project.event_ticket_booking_system.repository.UsersRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UsersRepo usersRepo;

    @Override
    public Users create(Users users) {
        if(users.getEmail()==null && users.getName()==null && users.getPassword()==null){
            throw new NullFieldException("A field can not be null");
        }
        return usersRepo.save(users);
    }

    @Override
    public List<Users> findAll() {
        return usersRepo.findAll();
    }

    @Override
    public Users login(Users users) {
        Optional<Users> users1=usersRepo.findByEmail(users.getEmail());

        if(users1.get().getEmail().equalsIgnoreCase(users.getEmail()) && users1.get().getPassword().equalsIgnoreCase(users.getPassword())){
            return users1.get();
        }
        throw new InvalidCredentialException("Invalid Credentials, Please try again");
    }
}

