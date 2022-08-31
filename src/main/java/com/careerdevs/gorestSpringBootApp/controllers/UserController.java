package com.careerdevs.gorestSpringBootApp.controllers;

import com.careerdevs.gorestSpringBootApp.models.UserModel;
import com.careerdevs.gorestSpringBootApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    // Define endpoint for any RestTemplate necessity
    private final String endpointURL = "https://gorest.co.in/public/v2/users";

    // Declare repository for use
    @Autowired
    private UserRepository userRepository;

    // GET users from GoRest endpoint
    @GetMapping("/gorest/all")
    public ResponseEntity<?> getAllUsersAPI(RestTemplate restTemplate) {
        try {
            UserModel[] allUsers = restTemplate.getForObject(endpointURL, UserModel[].class);

            return ResponseEntity.ok(allUsers);
        } catch (Exception e) {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    // GET a user from gorest_db
    @GetMapping("/id/{id}")
    public ResponseEntity<?> getOneUserAPI(@PathVariable String id) {
        try {
            int userId = Integer.parseInt(id);

            System.out.println("Retrieving user with ID of " + id);

            Optional<UserModel> foundUser = userRepository.findById(userId);

            if (foundUser.isEmpty()) return ResponseEntity.status(404).body("User Not Found With ID of " + id);

            return ResponseEntity.ok(foundUser);
        } catch (NumberFormatException e) {
            return ResponseEntity.status(400).body("ID: " + id + ", is not a valid id. Must be a whole number");

        } catch (HttpClientErrorException e) {
            return ResponseEntity.status(404).body("User Not Found With ID: " + id);

        } catch (Exception e) {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    // POST all users to gorest_db
    @PostMapping("/all")
    public ResponseEntity<?> uploadAllUsersToSQL(RestTemplate restTemplate) {
        try {
            UserModel[] allUsers = restTemplate.getForObject(endpointURL, UserModel[].class);

            assert allUsers != null;

            //TODO: remove id from each user, there is another way we MUST find
            for (UserModel user : allUsers) { user.removeId(); }

            List<UserModel> savedUsers = userRepository.saveAll(Arrays.asList(allUsers));

            return ResponseEntity.ok(savedUsers);
        } catch (Exception e) {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> postNewUser(@RequestBody UserModel newUser) {
        try {
            // What if we wanted to assign an id to a user? Could we make that possible and have the backend check to see if that ID is in use already?
            newUser.removeId();
            //TODO: Data validation on the new user data (make sure fields are valid)

            UserModel savedUser = userRepository.save(newUser);

            return ResponseEntity.ok(savedUser);
        } catch (Exception e) {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }


}
