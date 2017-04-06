package com.litereaction.tipping.model;

public class Selection {
    private String subEventId;
    private String offerId;

    public Selection() {

    }

    public Selection(String subEventId, String offerId) {
        this.subEventId = subEventId;
        this.offerId = offerId;
    }

    public String getSubEventId() {
        return subEventId;
    }

    public void setSubEventId(String subEventId) {
        this.subEventId = subEventId;
    }

    public String getOfferId() {
        return offerId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }

    @Override
    public String toString() {
        return "Selection{" +
                "subEventId='" + subEventId + '\'' +
                ", offerId='" + offerId + '\'' +
                '}';
    }
}
