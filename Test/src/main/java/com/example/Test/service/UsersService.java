package com.example.Test.service;

import com.example.Test.model.Users;
import com.example.Test.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UsersService {

    @Autowired
    private UsersRepo usersRepo;

    public String saveUsers(Users users) {
        Optional<Users> checkUser = usersRepo.findByNameAndEmail(users.getName(), users.getEmail());
        if (checkUser.isPresent()) {
            throw new RuntimeException("User already exists");
        }else{
            usersRepo.save(users);
            return "User Saved Successfully";
        }
    }
    public Optional<Users> getUsersById(UUID id) {

        try {
            return usersRepo.findById(id);
        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }

}
