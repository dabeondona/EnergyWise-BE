package com.energywise.energywise.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.energywise.energywise.Entity.UserEntity;
import com.energywise.energywise.Service.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/print")
    public String printHello() {
        return "Hello, Mic Test!";
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDto loginDto) {
        boolean isValidUser = userService.validateUser(loginDto.getUsername(), loginDto.getPassword());
        if (isValidUser) {
            return ResponseEntity.ok().body("User authenticated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    @PostMapping("/insertUser")
    public ResponseEntity<?> insertUser(@RequestBody UserRegistrationDto registrationDto) {
        UserEntity user = new UserEntity();
        user.setUsername(registrationDto.getUsername());
        user.setPassword(registrationDto.getPassword());
        user.setEmail(registrationDto.getEmail());
        user.setFirstname(registrationDto.getFirstname());
        user.setLastname(registrationDto.getLastname());

        UserEntity savedUser = userService.insertUser(user);

        UserDto userDto = mapToUserDto(savedUser);

        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }

    private UserDto mapToUserDto(UserEntity user) {
        UserDto userDto = new UserDto();
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());

        return userDto;
    }

    @GetMapping("/getAllUsers")
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/getUserPicture") // TBC
    public String getPicture(@RequestParam int user_id) {
        return userService.getPicture(user_id);
    }

    @PutMapping("/updateUser")
    public UserEntity updateUser(@RequestParam int user_id, @RequestBody UserEntity newUserDetails) {
        return userService.updateUser(user_id, newUserDetails);
    }

    @DeleteMapping("/deleteUser/{user_id}")
    public String deleteUser(@PathVariable int user_id) {
        return userService.deleteUser(user_id);
    }
}
