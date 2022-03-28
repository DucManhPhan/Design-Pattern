package com.manhpd.multiplication.service;

import com.manhpd.multiplication.domain.Multiplication;
import com.manhpd.multiplication.domain.MultiplicationResultAttempt;

import java.util.List;

public interface MultiplicationService {

    /**
     * Creates a Multiplication object with two randomly-generated factors between 11 and 99
     *
     * @return a multiplication of randomly generated numbers
     */
    Multiplication createRandomMultiplication();

    /**
     * @param resultAttempt
     * @return true if the attempt matches the result of the multiplication, false otherwise
     */
    boolean checkAttempt(final MultiplicationResultAttempt resultAttempt);

    /**
     * Gets the statistics for a given user
     *
     * @param userAlias the user's alias
     * @return a list of {@link MultiplicationResultAttempt} objects, being the past attempts of the user
     */
    List<MultiplicationResultAttempt> getStatsForUser(final String userAlias);

}
