package com.vti.todo.controller;

import com.vti.todo.dto.request.LoginRequest;
import com.vti.todo.dto.request.RegisterAccountRequest;
import com.vti.todo.dto.response.JwtResponse;
import com.vti.todo.entity.AccountEntity;
import com.vti.todo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping("/register")
    public AccountEntity registerNewAccount(@RequestBody @Valid RegisterAccountRequest registerAccountRequest){
        return accountService.registerNewAccount(registerAccountRequest);
    }
    @PostMapping("/login")
    public JwtResponse login(@Valid @RequestBody LoginRequest loginRequest){
        return accountService.login(loginRequest);
    }

    @GetMapping("/principal")
    public UserDetails principal(@AuthenticationPrincipal UserDetails userDetails) {
        return userDetails;
    }
}
