package com.example.demo.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data //gera getters/setters/toString/equals/hashCode
@Document(collection = "Users")
public class Users {
    @Id
    private String id;

    private String username;
    private String password;

}
