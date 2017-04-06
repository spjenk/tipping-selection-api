package com.litereaction.tipping;

import org.springframework.data.annotation.Id;

import java.util.Arrays;

public class TipSelection {

    @Id
    private String id;

    private String user;

    private String  meeting;

    private String[] selections;

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

    public String getMeeting() { return meeting; }

    public void setMeeting(String meeting) { this.meeting = meeting; }

    public String[] getSelections() {
        return selections;
    }

    public void setSelections(String[] selections) {
        this.selections = selections;
    }

    @Override
    public String toString() {
        return "TipSelection{" +
                "id='" + id + '\'' +
                ", user='" + user + '\'' +
                ", selections=" + Arrays.toString(selections) +
                '}';
    }
}
