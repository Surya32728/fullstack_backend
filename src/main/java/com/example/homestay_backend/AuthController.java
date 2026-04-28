package com.example.homestay_backend;

import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> user, HttpSession session) {

        String username = user.get("username");
        String password = user.get("password");

        if ("admin".equals(username) && "1234".equals(password)) {
            session.setAttribute("user", username);
            return "Login Successful";
        }

        return "Invalid Credentials";
    }
}