package com.example.demo.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Models.Users;
import com.example.demo.Repositories.UsersRepository;

@Service
public class UserService {

    @Autowired
    private UsersRepository userRepo;
    
    public Users createUser(Users user) {
        Optional<Users> usersSearch = userRepo.findByUsername(user.getUsername());
        if(usersSearch.isPresent()) {
            System.out.println("USUARIO JA CRIADO");
            return null;
        } else {
            Users userNew = userRepo.save(user);
            return userNew;
        }
    }
}
