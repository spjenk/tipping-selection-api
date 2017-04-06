package com.litereaction.tipping;

import com.litereaction.tipping.model.TipSelection;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TipSelectionRepository extends MongoRepository<TipSelection, String> {

    public List<TipSelection> findByUser(String user);

    public List<TipSelection> findByMeetingId(String meeting);

    public TipSelection findByUserAndMeetingId(String user, String meeting);

}