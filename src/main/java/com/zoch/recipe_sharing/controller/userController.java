package com.zoch.recipe_sharing.controller;

import com.zoch.recipe_sharing.model.user;
import com.zoch.recipe_sharing.repository.userRepository;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/User")

public class userController {
    private final userRepository userRepository;


    @Autowired
    public userController(userRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping(path = "/users")
    public user createUser(@RequestBody user user) throws Exception {
        // Check if the email is null
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new Exception("Email cannot be null or empty.");
        }

        // Check if a user with the same email already exists
        user isExist = userRepository.findByEmail(user.getEmail());
        if (isExist != null) {
            throw new Exception("User already exists with this email.");
        }

        return userRepository.save(user);
    }




    @DeleteMapping(path = "/users/{id}")
    public String deleteUser(@PathVariable Long id) throws Exception {

        // Check if a user with the same email already exists
       Optional<user>  isExist = userRepository.findById(id);
        if (isExist != null) {
            userRepository.deleteById(id);
            return "User with id " + id + " has been deleted successfully.";

        }
     throw new Exception("SOMETGING WENT WRONG");
    }


    @GetMapping(path = "/getAllUsers")
    public List<user> getAllUsers() throws Exception {

        // Check if a user with the same email already exists
       List<user> users=userRepository.findAll();
       return users;

    }

}
