package com.example.UserApplication.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    private Object[] purchasedProds;
}
