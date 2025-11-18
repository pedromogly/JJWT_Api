package com.example.demo.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Models.Users;

@Repository
public interface UsersRepository extends MongoRepository<Users, String> {
    Optional<Users> findByUsername(String username); //metodos personalizados de busca

    //filtros interessantes:
    List<Users> findByUsernameContaining(String termo);
    List<Users> findByUsernameStartingWith(String prefix);

}
