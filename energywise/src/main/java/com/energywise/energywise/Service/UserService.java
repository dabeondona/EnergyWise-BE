package com.energywise.energywise.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energywise.energywise.Entity.UserEntity;
import com.energywise.energywise.Repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepo;

    // C
    public UserEntity insertUser(UserEntity user) {
        return userRepo.save(user);
    }

    // R
    public List<UserEntity> getAllUsers() {
        return userRepo.findAll();
    }

    // R - GETTING PICTURE LINK
    public String getPicture(int user_id) {
        Optional<UserEntity> userOptional = userRepo.findById(user_id);

        if (userOptional.isPresent()) {
            return userOptional.get().getPicture();
        } else {
            throw new NoSuchElementException("User " + user_id + " not found!");
        }
    }

    // U - TO BE UTILIZED FOR THE SETTINGS PAGE
    @SuppressWarnings("finally")
    public UserEntity updateUser(int user_id, UserEntity newUserDetails) {
        UserEntity user = new UserEntity();

        try {
            user = userRepo.findById(user_id).get();
            user.setUsername(newUserDetails.getUsername());
            user.setFirstname(newUserDetails.getFirstname());
            user.setLastname(newUserDetails.getLastname());
            user.setPassword(newUserDetails.getPassword());
            user.setEmail(newUserDetails.getEmail());
            user.setPicture(newUserDetails.getPicture());
            user.setDeleted(newUserDetails.isDeleted());
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("User " + user_id + " not found!");
        } finally {
            return userRepo.save(user);
        }
    }

    // D
    public String deleteUser(int user_id) {
        String msg = "";

        if (userRepo.findById(user_id) != null) {
            userRepo.deleteById(user_id);
            msg = "User " + user_id + " is deleted!";
        } else {
            msg = "User " + user_id + " not found!";
        }
        return msg;
    }
}
