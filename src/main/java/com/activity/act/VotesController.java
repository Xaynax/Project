package com.activity.act;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class VotesController {
    private VotesDAO votesDAO;

    @Autowired
    public VotesController(VotesDAO votesDAO){
        this.votesDAO = votesDAO;
    }

    @GetMapping("/Vote")
    public ArrayList<Vote> getAllVotes(){
        return votesDAO.getVotes();
    }

    @GetMapping("/PersonVotes/{id}")
    public ArrayList<Activity> getAllActivitiesAnIDVotedFor(@PathVariable String id){
        return votesDAO.getActivities(id);
    }

    @GetMapping("/ActivityVotes/{id}")
    public ArrayList<Person> getAllPeopleThatVotedForAnActivity(@PathVariable String id){
        return votesDAO.getPeople(id);
    }

    @PostMapping("/Vote/{id}")
    public Vote vote(@PathVariable String id, @RequestBody Activity activity){
        return votesDAO.vote(id, activity);
    }
}
