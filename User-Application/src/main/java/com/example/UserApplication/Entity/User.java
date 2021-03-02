package com.example.UserApplication.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "USER_TABLE")
@Entity
public class User {
    @GeneratedValue
    @Id
    private int userId;
    private String userName;
    private String password;
    private String email;
}
