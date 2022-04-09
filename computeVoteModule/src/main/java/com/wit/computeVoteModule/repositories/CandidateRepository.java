package com.wit.computeVoteModule.repositories;

import com.wit.computeVoteModule.models.Candidate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CandidateRepository extends MongoRepository<Candidate, String> {

    @Query(value="{code:'?0'}")
    Candidate findCandidateByCode(String code);

    @Query(value="{code:'?0'}", fields="{'name' : 1}")
    List<Candidate> findAll(String category);
}
