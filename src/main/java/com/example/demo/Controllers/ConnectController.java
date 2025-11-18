package com.example.demo.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.Users;
import com.example.demo.Repositories.UsersRepository;
import com.example.demo.Services.UserService;

@RestController
@RequestMapping("/api/users")
public class ConnectController {
    private UsersRepository usersRepository;
    private UserService userService;
    public ConnectController(UsersRepository usersRepo,UserService userServ) {
        this.userService = userServ;
        this.usersRepository = usersRepo;
    }

    @GetMapping("/allusers")
    public List<Users> buscarTodosUsers(){
        return usersRepository.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<Users> criarUser(@RequestBody Users user) {
        Users newUser = userService.createUser(user);
        if(newUser==null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
}