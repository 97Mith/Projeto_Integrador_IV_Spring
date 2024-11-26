package com.example.marcos.pi4_2.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class LoginController {
    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        @RequestParam("role") String role) {

        if ("aluno".equalsIgnoreCase(role)) {
            return "redirect:/aluno-home/feed";
        } else {
            return "redirect:/home";
        }
    }
}
