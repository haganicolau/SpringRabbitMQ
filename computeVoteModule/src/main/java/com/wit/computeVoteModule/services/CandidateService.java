package com.wit.computeVoteModule.services;

import com.wit.computeVoteModule.models.Calzone;
import com.wit.computeVoteModule.models.NyPizza;
import com.wit.computeVoteModule.models.Pizza;
import com.wit.computeVoteModule.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    public void addVote(String code) {
//        Candidate candidate = this.candidateRepository.findCandidateByCode(code);
//        candidate.addVotes();
//        this.candidateRepository.save(candidate);
        NyPizza nyPizza = new NyPizza.Builder(NyPizza.Size.SMALL)
                .addToping(Pizza.Topping.SAUSAGE)
                .addToping(Pizza.Topping.ONION)
                .build();

        Calzone calzonePizza = new Calzone.Builder()
                .addToping(Pizza.Topping.HAM)
                .sauceInside()
                .build();
    }
}
