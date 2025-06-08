package com.principles.DDD.presentation.user.controller;

import com.principles.DDD.application.user.handlers.UserHandler;
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
    private final UserHandler handler;

    public UserController(final UserHandler handler) {
        this.handler = handler;
    }

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody final UserRequest requestEntity) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(handler.create(requestEntity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable final String id) throws Exception {
        return ResponseEntity.ok(handler.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> findAll() throws Exception {
        return ResponseEntity.ok(handler.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final String id) throws Exception {
        handler.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> update(
            @PathVariable final String id,
            @RequestBody final UserRequest requestEntity
    ) throws Exception {
        return ResponseEntity.ok(handler.update(id, requestEntity));
    }
}
