package com.example.demo.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.UserInfoService;
import com.example.demo.model.AuthRequest;
import com.example.demo.util.JwtUtil;

@RestController
public class JwtController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserInfoService userDetailsService;

    @PostMapping("/authenticateAPI")
    public String authenticate(@RequestBody AuthRequest authRequest) throws Exception {
        try {
        	authenticationManager.authenticate(
        			new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        	
            final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
            return jwtUtil.generateToken(userDetails.getUsername());
        } 
        catch (AuthenticationException e) {
            throw new Exception("Invalid username or password", e);
        }
    }
}
