package com.wit.computeVoteModule.models;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "candidates")
public class Candidate {

    @MongoId
    private String id;
    private String name;
    private String code;
    private int votesNumber;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getVotesNumber() {
        return votesNumber;
    }

    public void setVotesNumber(int votesNumber) {
        this.votesNumber = votesNumber;
    }

    public void addVotes() {
        this.votesNumber++;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", qtdVotes='" + votesNumber + '\'' +
                '}';
    }
}
