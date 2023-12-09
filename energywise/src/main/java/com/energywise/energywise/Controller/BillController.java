package com.energywise.energywise.Controller;

import java.util.ArrayList;
import java.util.List;

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

@RestController
@RequestMapping("/bill")
public class BillController {

    private final List<User> users = new ArrayList<>();

    @GetMapping("/print")
    public String printHello() {
        return "Hello, Mic Test!";
    }

    @PostMapping("/create")
    public ResponseEntity<String> createBill(@RequestBody User user) {
        Long userId = user.getUserId();

        if (userId == null || userExists(userId)) {
            return new ResponseEntity<>("userId already exists", HttpStatus.BAD_REQUEST);
        }

        users.add(user);
        return new ResponseEntity<>("Bill created successfully", HttpStatus.CREATED);
    }

    private boolean userExists(Long userId) {
        return users.stream()
                .anyMatch(existingUser -> existingUser.getUserId() != null && existingUser.getUserId().equals(userId));
    }

    @PutMapping("/update/userId/{userId}")
    public ResponseEntity<String> updateBill(@PathVariable Long userId, @RequestBody User updatedUser) {
        User existingUser = findUserById(userId);

        if (existingUser != null) {
            return new ResponseEntity<>("Bill updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Bill not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/userId/{userId}")
    public ResponseEntity<String> deleteBill(@PathVariable Long userId) {
        User existingUser = findUserById(userId);

        if (existingUser != null) {
            users.remove(existingUser);
            return new ResponseEntity<>("Bill deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Bill not found", HttpStatus.NOT_FOUND);
        }
    }

    private User findUserById(Long userId) {
        return users.stream()
                .filter(user -> user.getUserId().equals(userId))
                .findFirst()
                .orElse(null);
    }

    public static class User {
        private Long userId;

        public User() {
            // Default constructor
        }

        public User(Long userId) {
            this.userId = userId;
        }

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }
    }
}
