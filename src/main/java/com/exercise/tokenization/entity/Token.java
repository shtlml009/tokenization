package com.exercise.tokenization.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "tokens")
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "original_value")
    private String originalValue;

    @Column(name = "token_value", nullable = false, unique = true)
    private String tokenValue;

    public Token(){};

    public Token(String originalValue, String tokenValue) {
        this.originalValue = originalValue;
        this.tokenValue = tokenValue;
    }

    public long getId(){
        return id;
    }

    public String getOriginalValue() {
        return originalValue;
    }

    public void setOriginalValue(String originalValue) {
        this.originalValue = originalValue;
    }

    public String getTokenValue() {
        return tokenValue;
    }

    public void setTokenValue(String tokenValue) {
        this.tokenValue = tokenValue;
    }
}
