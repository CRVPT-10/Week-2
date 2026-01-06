
package com.example.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.myapp.repository.UserRepository;
import com.example.myapp.model.User;
import com.example.myapp.dto.SignupRequest;
import com.example.myapp.dto.LoginRequest;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepo;

    public String signup(SignupRequest req) {
        if (userRepo.findByEmail(req.getEmail()).isPresent()) {
            return "Email already exists";
        }

        User user = new User();
        user.setName(req.getName());
        user.setEmail(req.getEmail());
        user.setPassword(req.getPassword()); // (plain for now)

        userRepo.save(user);
        return "Signup successful";
    }

    public String login(LoginRequest req) {
        return userRepo.findByEmail(req.getEmail())
                .filter(u -> u.getPassword().equals(req.getPassword()))
                .map(u -> "Login successful")
                .orElse("Invalid email or password");
    }

    public java.util.List<User> getAllUsers() {
        return userRepo.findAll();
    }
}
