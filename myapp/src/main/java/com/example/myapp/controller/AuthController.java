package com.example.myapp.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.myapp.dto.LoginRequest;
import com.example.myapp.dto.SignupRequest;
import com.example.myapp.service.AuthService;
@RestController
@RequestMapping("/api")
public class AuthController {
@Autowired
private AuthService authService;
@PostMapping("/signup")
public String signup (@RequestBody SignupRequest req) {
return authService.signup(req);
}
@PostMapping("/login")
public String login (@RequestBody LoginRequest req) {
return authService.login(req);
}
}