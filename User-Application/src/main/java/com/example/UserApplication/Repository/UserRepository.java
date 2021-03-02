package com.example.UserApplication.Repository;

import com.example.UserApplication.Entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
