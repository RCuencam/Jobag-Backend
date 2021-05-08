package com.example.jobagapi.domain.controller;

import com.example.jobagapi.domain.model.Postulant;
import com.example.jobagapi.domain.model.User;
import com.example.jobagapi.domain.resource.PostulantResource;
import com.example.jobagapi.domain.resource.SavePostulantResource;
import com.example.jobagapi.domain.resource.SaveUserResource;
import com.example.jobagapi.domain.resource.UserResource;
import com.example.jobagapi.domain.service.PostulantService;
import com.example.jobagapi.domain.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper mapper;



    @Operation(summary="Get Users", description="Get All Users", tags={"Users"})
    @GetMapping("/users")
    public Page<UserResource> getAllUsers(Pageable pageable){
        Page<User> userPage = userService.getAllUsers(pageable);
        List<UserResource> resources = userPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());

        return new PageImpl<>(resources, pageable, resources.size());
    }
    @Operation(summary="User users", description="User users", tags={"Users"})
    @PostMapping("/users")
    public UserResource createUser(@Valid @RequestBody SaveUserResource resource) {
        User user = convertToEntity(resource);
        return convertToResource(userService.createUser(user));
    }

    @Operation(summary="Get UsersById", description="Get UsersById", tags={"Users"})
    @GetMapping("/user/{id}")
    public UserResource getUserById(@PathVariable(name = "id") Long userId) {
        return convertToResource(userService.getUserById(userId));
    }

    @Operation(summary="Delete User By Id", description="DeleteUserById", tags={"Users"})
    @DeleteMapping("/user/{postId}}")

    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        return userService.deleteUser(userId);
    }







    private User convertToEntity(SaveUserResource resource) {
        return mapper.map(resource, User.class);
    }
    private UserResource convertToResource(User entity)
    {
        return mapper.map(entity, UserResource.class);
    }




}
