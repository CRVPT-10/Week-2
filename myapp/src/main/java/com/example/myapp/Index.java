package com.example.myapp;
import com.example.myapp.dto.M;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Index {
    @GetMapping("/")
    public M m() {
        return new M();
    }
    
}
