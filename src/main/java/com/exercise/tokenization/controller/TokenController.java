package com.exercise.tokenization.controller;

import com.exercise.tokenization.entity.Token;
import com.exercise.tokenization.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TokenController {

    private final TokenService tokenService;

    @Autowired
    public TokenController(TokenService tokenService){
        this.tokenService = tokenService;
    }

    @PostMapping("/tokenize")
    public List<String> tokenize(@RequestBody List<String> request) {
        return request.stream()
                .map(value -> tokenService.generateToken(value).getTokenValue())
                .collect(Collectors.toList());
    }

    @PostMapping("/detokenize")
    public List<String> detokenize(@RequestBody List<String> request) {
        return request.stream()
                .map(token -> tokenService.getToken(token)
                        .map(Token::getOriginalValue)
                        .orElse("NOT_FOUND"))
                .collect(Collectors.toList());
    }

}


