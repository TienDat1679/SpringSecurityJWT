package com.example.demo.restcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.UserInfo;

@Controller
public class TestController {
	
	@GetMapping("/test")
	public String showRegistrationForm(Model model) {
        model.addAttribute("userInfo", new UserInfo());
        return "test";
    }

}
