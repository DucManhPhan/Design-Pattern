package com.manhpd.multiplication.service;

import com.manhpd.multiplication.domain.Multiplication;
import com.manhpd.multiplication.domain.MultiplicationResultAttempt;
import com.manhpd.multiplication.domain.User;
import com.manhpd.multiplication.repository.MultiplicationResultAttemptRepository;
import com.manhpd.multiplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class MultiplicationServiceImpl implements MultiplicationService {

    private RandomGeneratorService randomGeneratorService;

    private MultiplicationResultAttemptRepository attemptRepository;

    private UserRepository userRepository;

    @Autowired
    public MultiplicationServiceImpl(final RandomGeneratorService randomGeneratorService,
                                     final MultiplicationResultAttemptRepository attemptRepository,
                                     final UserRepository userRepository) {
        this.randomGeneratorService = randomGeneratorService;
        this.attemptRepository = attemptRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Multiplication createRandomMultiplication() {
        int factorA = this.randomGeneratorService.generateRandomFactor();
        int factorB = this.randomGeneratorService.generateRandomFactor();

        return new Multiplication(factorA, factorB);
    }

    @Transactional
    @Override
    public boolean checkAttempt(MultiplicationResultAttempt resultAttempt) {
        // Check if the optUser already exists for that alias
        Optional<User> optUser = this.userRepository.findByAlias(resultAttempt.getUser().getAlias());

        // Avoids hack attempts
        Assert.isTrue(!resultAttempt.isCorrect(), "You can't send an attempt marked as correct!!");

        // Checks if it's correct
        boolean isCorrect = resultAttempt.getResultAttempt() ==
                                resultAttempt.getMultiplication().getFactorA() *
                                resultAttempt.getMultiplication().getFactorB();

        // Creates a copy, now setting the correct field accordingly
        MultiplicationResultAttempt checkedAttempt = new MultiplicationResultAttempt(
                                                                optUser.orElse(resultAttempt.getUser()),
                                                                resultAttempt.getMultiplication(),
                                                                resultAttempt.getResultAttempt(),
                                                                isCorrect);

        // Stores the attempt
        this.attemptRepository.save(checkedAttempt);

        // Returns the result
        return isCorrect;
    }

    @Override
    public List<MultiplicationResultAttempt> getStatsForUser(String userAlias) {
        return this.attemptRepository.findTop5ByUserAliasOrderByIdDesc(userAlias);
    }
}
