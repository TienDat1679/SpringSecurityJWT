package com.example.demo.restcontroller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vendor")
//@PreAuthorize("hasRole('VENDOR')")
public class VendorController {
	@GetMapping("/home")
    public String getMethodName() {
        return "vendor/home";
    }
}
