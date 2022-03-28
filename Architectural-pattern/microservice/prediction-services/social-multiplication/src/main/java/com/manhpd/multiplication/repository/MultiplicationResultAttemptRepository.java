package com.manhpd.multiplication.repository;

import com.manhpd.multiplication.domain.MultiplicationResultAttempt;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MultiplicationResultAttemptRepository extends CrudRepository<MultiplicationResultAttempt, Long> {

    /**
     * @param userAlias
     * @return the latest 5 attempts for a given user, identified by their alias.
     */
    List<MultiplicationResultAttempt> findTop5ByUserAliasOrderByIdDesc(String userAlias);

}
