package com.example.demo.restcontroller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
//@PreAuthorize("hasRole('USER')")
public class UserController {
    @GetMapping("/home")
    public String getMethodName() {
        return "user/home";
    }
}
