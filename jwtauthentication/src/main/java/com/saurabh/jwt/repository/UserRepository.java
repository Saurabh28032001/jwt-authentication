package com.saurabh.jwt.repository;

import org.springframework.data.repository.CrudRepository;

import com.saurabh.jwt.entities.User;

public interface UserRepository extends CrudRepository<User, String> {

}
