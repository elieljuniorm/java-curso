package com.elieldev.cursojava.resources;

import com.elieldev.cursojava.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

  @GetMapping
  public ResponseEntity<User> findAll() {
    User u = new User(1L, "Eliel", "eliel@gmail.com", "12345678", "654321");
    return ResponseEntity.ok().body(u);
  }
}
