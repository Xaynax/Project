package com.activity.act;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class ActivityDAO {
    ArrayList<Activity> allActivities;

    public List<Activity> getAllActivities() {
        return allActivities;
    }

    public void setAllActivities(ArrayList<Activity> allActivities) {
        this.allActivities = allActivities;
    }

    ActivityDAO(){
        allActivities = new ArrayList<Activity>();
    }

    public Activity findActivityByTitle(String title){
        for (Activity activity : allActivities){
            if (activity.getTitle().equals(title)){
                return activity;
            }
        }
        return null;
    }

    public void patch(Activity activity, String title) {
        Activity oldActivity = findActivityByTitle(activity.getTitle());
        allActivities.remove(oldActivity);
        addActivity(activity);
    }

    public Activity removeActivity(String title) {
        Activity activity = findActivityByTitle(title);
        allActivities.remove(activity);
        return activity;
    }


    public Activity addActivity(Activity activity) {
        if(findActivityByTitle(activity.getTitle()) == null) {
            if(activity.getId() == null) {
                String id = UUID.randomUUID().toString();
                activity.setId(id);
            }
            allActivities.add(activity);
        }/*
        if(activity.getPeopleInterested() == null){
            activity.setPeopleInterested(new ArrayList<Person>());
        }*/
        return activity;
    }

    public Activity findActivityById(String activityID) {
        for (Activity activity : allActivities){
            if (activity.getTitle().equals(activityID)){
                return activity;
            }
        }
        return null;
    }
    /*
    public Activity voteForActivity(Activity act, Person person) {
        Activity activity = findActivityByTitle(act.getTitle());
        if (activity.peopleInterested.indexOf(person) == -1) {
            activity.peopleInterested.add(person);
        }
        return activity;
    }

    public Activity removeVoteForActivity(Activity act, Person person) {
        Activity activity = findActivityByTitle(act.getTitle());
        if (activity.peopleInterested.indexOf(person) != -1) {
            activity.peopleInterested.remove(person);
        }
        return activity;
    }*/
}
