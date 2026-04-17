package com.exercise.tokenization.service;

import com.exercise.tokenization.entity.Token;
import com.exercise.tokenization.repository.TokenRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TokenServiceTest {

    @Mock
    private TokenRepo tokenRepo;

    @InjectMocks
    private TokenServiceImpl tokenService;

    @Test
    void tokenizeCollectionOfAccountNumbers() {

        List<String> accountNumbers = List.of("4111-1111-1111-1111", "4444-3333-2222-1111");


        when(tokenRepo.save(any(Token.class))).thenAnswer(invocation -> invocation.getArgument(0));

        List<String> tokens = accountNumbers.stream()
                .map(acc -> tokenService.generateToken(acc).getTokenValue())
                .toList();

        assertThat(tokens).hasSize(2);
        assertThat(tokens.get(0)).isNotBlank().hasSize(32);
        verify(tokenRepo, times(2)).save(any(Token.class));
    }

    @Test
    void detokenizeCollectionOfTokens() {

        String tokenVal = "fvMymE7X0Je1IzMDgWooV5iGBPw0yoFy";
        String originalAcc = "4111-1111-1111-1111";

        Token mockToken = new Token(originalAcc, tokenVal);
        when(tokenRepo.findByTokenValue(tokenVal)).thenReturn(Optional.of(mockToken));

        Optional<Token> result = tokenService.getToken(tokenVal);

        assertThat(result).isPresent();
        assertThat(result.get().getOriginalValue()).isEqualTo(originalAcc);
    }
    }
