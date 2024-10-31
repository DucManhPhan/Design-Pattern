package com.github.chavdarb.flowable.registration.service;

import com.github.chavdarb.flowable.registration.api.model.Token;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

/**
 * Service for generating new tokens.
 */
@Service
public class TokenGeneratorService {

    private static final Random random = new Random();

    /**
     * Create new Token.
     *
     * @return Returns new token.
     */
    public Token generateToken() {
        Token token = new Token();
        token.setId(UUID.randomUUID().toString());
        token.setCreationTime(LocalDateTime.now());
        token.setValue(String.valueOf(getRandomNumber(100000, 999999)));
        return token;
    }

    public int getRandomNumber(int min, int max) {
        return random.nextInt(max - min) + min;
    }

}
