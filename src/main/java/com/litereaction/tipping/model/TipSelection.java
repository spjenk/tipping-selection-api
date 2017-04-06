package com.litereaction.tipping.model;

import com.litereaction.tipping.model.Selection;
import org.springframework.data.annotation.Id;

import java.util.Arrays;

public class TipSelection {

    @Id
    private String id;

    private String user;

    private String meetingId;

    private Selection[] selections;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMeetingId() { return meetingId; }

    public void setMeetingId(String meetingId) { this.meetingId = meetingId; }

    public Selection[] getSelections() {
        return selections;
    }

    public void setSelections(Selection[] selections) {
        this.selections = selections;
    }

    @Override
    public String toString() {
        return "TipSelection{" +
                "id='" + id + '\'' +
                ", user='" + user + '\'' +
                ", meetingId='" + meetingId + '\'' +
                ", selections=" + Arrays.toString(selections) +
                '}';
    }
}


