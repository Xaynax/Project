package com.activity.act;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class VotesDAO {
    private PeopleDAO peopleDAO;
    private ActivityDAO activityDAO;
    private ArrayList<Vote> votesList;
    private ArrayList<Person> peopleWhoVotedForThatActivity;
    private ArrayList<Activity> activitiesThatPersonVoteFor;

    @Autowired
    VotesDAO(PeopleDAO peopleDAO, ActivityDAO activityDAO){
        this.peopleDAO = peopleDAO;
        this.activityDAO = activityDAO;
        votesList = new ArrayList<>();
    }


    public Vote vote(String id, Activity activity1) {
        Activity activity = activityDAO.findActivityByTitle(activity1.getTitle());
        //person.addVote(activity1);
        //activity1.addVote(person);
        Vote vote = new Vote(id, activity.getId());
        votesList.add(vote);
        return vote;
    }

    public ArrayList<Vote> getVotes() {
        return votesList;
    }

    public ArrayList<Activity> getActivities(String id) {
        activitiesThatPersonVoteFor = new ArrayList<>();
        for (Vote vote : votesList){
            if (vote.getPersonID().equals(id)){
                activitiesThatPersonVoteFor.add(activityDAO.findActivityById(vote.getActivityID()));
            }
        }
        return activitiesThatPersonVoteFor;
    }

    public ArrayList<Person> getPeople(String id){
        peopleWhoVotedForThatActivity = new ArrayList<>();
        for (Vote vote : votesList){
            if (vote.getActivityID().equals(id)){
                peopleWhoVotedForThatActivity.add(peopleDAO.findPersonById(vote.getPersonID()));
            }
        }
        return peopleWhoVotedForThatActivity;
    }
}
