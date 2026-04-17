package com.exercise.tokenization.repository;

import com.exercise.tokenization.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface TokenRepo extends JpaRepository<Token, Long>{

    Optional<Token> findByTokenValue(String tokenValue);
    Boolean existsByTokenValue(String tokenValue);
}
