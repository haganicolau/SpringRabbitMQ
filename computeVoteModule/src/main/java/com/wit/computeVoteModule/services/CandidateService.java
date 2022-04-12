package com.wit.computeVoteModule.services;

import com.wit.computeVoteModule.models.Candidate;
import com.wit.computeVoteModule.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    public void addVote(String code) {
        Candidate candidate = this.candidateRepository.findCandidateByCode(code);
        candidate.addVotes();
        this.candidateRepository.save(candidate);
    }
}
