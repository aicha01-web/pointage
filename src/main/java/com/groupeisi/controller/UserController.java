package com.groupeisi.controller;

import com.groupeisi.domain.AppUser;
import com.groupeisi.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserController {

    UserService userService;

    @GetMapping("/users")
    public Page<AppUser> getUsers(Pageable pageable) {
        return userService.getUsers(pageable);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<AppUser> getUser(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.getUser(id));
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    //@IsAdmin
    public AppUser createUser(@Valid @RequestBody AppUser appUser) {
        return userService.createUser(appUser);
    }

    @PutMapping("/users/{id}")
    //@IsAdmin
    public AppUser updateAppUser(@PathVariable("id") Long id, @Valid @RequestBody AppUser appUser) {
        return userService.updateUser(id, appUser);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }
    
}
