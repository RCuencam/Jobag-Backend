package com.example.jobagapi.domain.repository;


import com.example.jobagapi.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    List<User> findAllByFirstname(String firstname);  //encuentra todos por Id
    List<User> findAllByLastname(String lastname);  //encuentra todos por Id
}
