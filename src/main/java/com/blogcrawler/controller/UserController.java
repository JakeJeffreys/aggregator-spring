package com.blogcrawler.controller;

import com.blogcrawler.exception.ResourceNotFoundException;
import com.blogcrawler.model.User;
import com.blogcrawler.repository.UserRepository;
import com.blogcrawler.security.CurrentUser;
import com.blogcrawler.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }

    @PutMapping("user/blogs")
    public User addBlogSelections(@RequestBody User user) {
        return userRepository.save(user);
    }
}
