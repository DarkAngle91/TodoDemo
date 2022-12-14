package com.vti.todo.service;

import com.vti.todo.dto.request.LoginRequest;
import com.vti.todo.dto.request.RegisterAccountRequest;
import com.vti.todo.dto.response.JwtResponse;
import com.vti.todo.entity.AccountEntity;
import com.vti.todo.repository.AccountRepository;
import com.vti.todo.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;


    @Autowired
    private JwtTokenProvider jwtTokenProvider;


    @Autowired
    private AuthenticationConfiguration authenticationConfiguration;


    public AccountEntity registerNewAccount(RegisterAccountRequest registerAccountRequest) {
        AccountEntity account = new AccountEntity();
        account.setEmail(registerAccountRequest.getEmail());
        account.setFullName(registerAccountRequest.getFullName());
        account.setPassword(registerAccountRequest.getPassword());
        accountRepository.save(account);
        return account;
    }


    public JwtResponse login(LoginRequest loginRequest) {
        try {
            AuthenticationManager authenticationManager = authenticationConfiguration.getAuthenticationManager();
            Authentication authenticate = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
            );
            String token = jwtTokenProvider.createToken(authenticate.getName(), authenticate.getAuthorities());
            return new JwtResponse(token);
        } catch (Exception e) {
            return new JwtResponse();
        }

    }
}
