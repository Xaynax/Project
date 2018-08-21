package com.activity.act;

public class Vote {
    private String personID;
    private String activityID;

    public Vote(String personID, String activityID) {
        this.personID = personID;
        this.activityID = activityID;
    }

    public String getActivityID() {
        return activityID;
    }

    public void setActivityID(String activityID) {
        this.activityID = activityID;
    }

    public String getPersonID() {
        return personID;
    }

    public void setPersonID(String personID) {
        this.personID = personID;
    }
}
