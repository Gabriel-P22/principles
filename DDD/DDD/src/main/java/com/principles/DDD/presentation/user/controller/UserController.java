package com.principles.DDD.presentation.user.controller;

import com.principles.DDD.application.user.handlers.CreateANewUserHandler;
import com.principles.DDD.application.user.handlers.DeleteUserHandler;
import com.principles.DDD.application.user.handlers.FindUserHandler;
import com.principles.DDD.application.user.handlers.UpdateUserHandler;
import com.principles.DDD.presentation.user.dtos.UserRequest;
import com.principles.DDD.presentation.user.dtos.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final CreateANewUserHandler createANewUserHandler;
    private final FindUserHandler findUserHandler;
    private final DeleteUserHandler deleteUserHandler;
    private final UpdateUserHandler updateUserHandler;

    public UserController(final CreateANewUserHandler createANewUserHandler,
                          final FindUserHandler findUserHandler,
                          final DeleteUserHandler deleteUserHandler,
                          final UpdateUserHandler updateUserHandler) {
        this.createANewUserHandler = createANewUserHandler;
        this.findUserHandler = findUserHandler;
        this.deleteUserHandler = deleteUserHandler;
        this.updateUserHandler = updateUserHandler;
    }

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody final UserRequest requestEntity) throws Exception {
        return ResponseEntity.status(201).body(createANewUserHandler.createANewUser(requestEntity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable final String id) throws Exception {
        return ResponseEntity.ok(findUserHandler.find(id));
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> findAll() throws Exception {
        return ResponseEntity.ok(findUserHandler.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final String id) throws Exception {
        deleteUserHandler.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> update(
            @PathVariable final String id,
            @RequestBody final UserRequest requestEntity
    ) throws Exception {
        return ResponseEntity.ok(updateUserHandler.update(id, requestEntity));
    }
}
