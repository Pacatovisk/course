package com.pacatovisk.course.resources;

import com.pacatovisk.course.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll() {
        return ResponseEntity.ok().body( new User(1, "Marcelo", "marce", "32323232","32323232"));
    }

}
