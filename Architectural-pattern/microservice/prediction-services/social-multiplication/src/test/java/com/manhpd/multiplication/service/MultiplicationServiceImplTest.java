package com.manhpd.multiplication.service;

import com.manhpd.multiplication.domain.Multiplication;
import com.manhpd.multiplication.domain.MultiplicationResultAttempt;
import com.manhpd.multiplication.domain.User;
import com.manhpd.multiplication.repository.MultiplicationResultAttemptRepository;
import com.manhpd.multiplication.repository.UserRepository;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

public class MultiplicationServiceImplTest {

    private MultiplicationService multiplicationService;

    @Mock
    private RandomGeneratorService randomGeneratorService;

    @Mock
    private MultiplicationResultAttemptRepository attemptRepository;

    @Mock
    private UserRepository userRepository;

    @Before
    public void setUp() {
        // With this call to initMocks, we tell Mockito to process the annotations
        MockitoAnnotations.initMocks(this);
        this.multiplicationService = new MultiplicationServiceImpl(this.randomGeneratorService,
                                                                   attemptRepository, userRepository);
    }

    @Test
    public void createRandomMultiplicationTest() {
        // given
        given(this.randomGeneratorService.generateRandomFactor()).willReturn(50, 30);

        // when
        Multiplication multiplication = this.multiplicationService.createRandomMultiplication();

        // then
        assertThat(multiplication.getFactorA()).isEqualTo(50);
        assertThat(multiplication.getFactorB()).isEqualTo(30);
    }

    @Test
    public void checkCorrectAttemptTest() {
        // given
        Multiplication multiplication = new Multiplication(50, 60);
        User user = new User("john_doe");
        MultiplicationResultAttempt attempt = new MultiplicationResultAttempt(user, multiplication, 3000, false);
        MultiplicationResultAttempt verifiedAttempt = new MultiplicationResultAttempt(user, multiplication, 3000, true);
        given(this.userRepository.findByAlias("john_doe")).willReturn(Optional.empty());

        // when
        boolean attemptResult = this.multiplicationService.checkAttempt(attempt);

        // assert
        assertThat(attemptResult).isTrue();
        verify(this.attemptRepository).save(verifiedAttempt);
    }

    @Test
    public void checkWrongAttemptTest() {
        // given
        Multiplication multiplication = new Multiplication(50, 60);
        User user = new User("john_doe");
        MultiplicationResultAttempt attempt = new MultiplicationResultAttempt(user, multiplication, 3010, false);
        given(this.userRepository.findByAlias("john_doe")).willReturn(Optional.empty());

        // when
        boolean attemptResult = this.multiplicationService.checkAttempt(attempt);

        // assert
        assertThat(attemptResult).isFalse();
        verify(this.attemptRepository).save(attempt);
    }

    @Test
    public void retrieveStatsTest() {
        // given
        Multiplication multiplication = new Multiplication(50, 60);
        User user = new User("john_doe");
        MultiplicationResultAttempt attempt1 = new MultiplicationResultAttempt(user, multiplication, 3010, false);
        MultiplicationResultAttempt attempt2 = new MultiplicationResultAttempt(user, multiplication, 3051, false);
        List<MultiplicationResultAttempt> latestAttempts = Lists.newArrayList(attempt1, attempt2);

        given(this.userRepository.findByAlias("john_doe")).willReturn(Optional.empty());
        given(this.attemptRepository.findTop5ByUserAliasOrderByIdDesc("john_doe")).willReturn(latestAttempts);

        // when
        List<MultiplicationResultAttempt> latestAttemptResult = this.multiplicationService.getStatsForUser("john_doe");

        // then
        assertThat(latestAttemptResult).isEqualTo(latestAttempts);
    }

}
