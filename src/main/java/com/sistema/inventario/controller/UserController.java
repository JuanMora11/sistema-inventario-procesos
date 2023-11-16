package com.sistema.inventario.controller;

import com.sistema.inventario.model.User;
import com.sistema.inventario.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("users")
    public ResponseEntity<User> create(@RequestBody User user){
        return new ResponseEntity(userService.createUser(user), HttpStatus.CREATED);
    }

    @GetMapping("users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PutMapping("users/{id}")
    public ResponseEntity<User> update(@RequestBody User user, @PathVariable Long id){
        return ResponseEntity.ok(userService.updateUser(user,id));
    }

    @DeleteMapping("users/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        userService.deleteUserById(id);
        return new ResponseEntity("Se eliminó su usuario",HttpStatus.NO_CONTENT);
    }

    @GetMapping("users")
    public ResponseEntity<List<User>> getAll(){
        return ResponseEntity.ok(userService.findAllUsers());
    }
}
