package com.example.jobagapi.domain.service;

import com.example.jobagapi.domain.model.Postulant;
import com.example.jobagapi.domain.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface UserService {
    Page<User> getAllUsers(Pageable pageable);
    User getUserById(Long userId);
    User createUser(User user);

    ResponseEntity<?> deleteUser(Long postulantId);
}
