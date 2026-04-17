package com.exercise.tokenization.service;

import com.exercise.tokenization.entity.Token;
import com.exercise.tokenization.repository.TokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Optional;

@Service
public class TokenServiceImpl implements TokenService{

    private final TokenRepo tokenRepo;

    @Autowired
    public TokenServiceImpl(TokenRepo tokenRepo){
        this.tokenRepo = tokenRepo;
    }

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int TOKEN_LENGTH = 32;
    private static final SecureRandom random = new SecureRandom();

    private String generateRandomToken() {
        StringBuilder token = new StringBuilder(TOKEN_LENGTH);

        for (int i = 0; i < TOKEN_LENGTH; i++) {
            int index = random.nextInt(CHARACTERS.length());
            token.append(CHARACTERS.charAt(index));
        }

        return token.toString();
    }

  @Override
    public Token generateToken(String originalValue){

        String tokenValue = generateRandomToken();

        Token token = new Token();
        token.setOriginalValue(originalValue);
        token.setTokenValue(tokenValue);

        return tokenRepo.save(token);
    }

    @Override
    public Optional<Token> getToken(String tokenValue){

        return tokenRepo.findByTokenValue(tokenValue);
    }

    @Override
    public boolean validateToken(String tokenValue){

        return tokenRepo.existsByTokenValue(tokenValue);
    }
}
