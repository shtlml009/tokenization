package com.exercise.tokenization.service;

import com.exercise.tokenization.entity.Token;
import java.util.Optional;

public interface TokenService {

        Token generateToken(String originalValue);
        Optional<Token> getToken(String tokenValue);
        boolean validateToken(String tokenValue);
}

