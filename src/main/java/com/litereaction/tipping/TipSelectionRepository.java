package com.litereaction.tipping;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TipSelectionRepository extends MongoRepository<TipSelection, String> {

    public List<TipSelection> findByUser(String user);

    public List<TipSelection> findByMeeting(String meeting);

    public TipSelection findByUserAndMeeting(String user, String meeting);

}