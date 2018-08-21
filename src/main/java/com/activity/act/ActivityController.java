package com.activity.act;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ActivityController {
    private ActivityDAO activityDAO;

    @Autowired
    ActivityController(ActivityDAO activityDAO){
        this.activityDAO = activityDAO;
    }

    @GetMapping("/Activity")
    public List<Activity> getActivities(){
        return activityDAO.getAllActivities();
    }

    @GetMapping("/Activity/{name}")
    public Activity getPersonById(@PathVariable String title){
        Activity activity = activityDAO.findActivityByTitle(title);
        return activity;
    }

    @PostMapping("/Activity")
    public Activity addActivity(@RequestBody Activity activity){
        return activityDAO.addActivity(activity);
    }

    /*
    @PostMapping("/Activity/Vote/{id}")
    public Activity voteForActivity(@PathVariable String id, @RequestBody Activity activity){
        return activityDAO.voteForActivity(activity, PeopleDAO.findPersonById(id));
    }*/

    @PatchMapping("/Activity/{name}")
    public void changeActivity(@RequestBody Activity activity, @PathVariable String title){
        activityDAO.patch(activity, title);
    }

    @DeleteMapping("Activity/{name}")
    public void removeActivity(@PathVariable String title){
        activityDAO.removeActivity(title);
    }

    /*@DeleteMapping("Activity/Vote/{id}")
    public Activity removeVoteForActivity(@PathVariable String id, @RequestBody Activity activity){
        return activityDAO.removeVoteForActivity(activity, PeopleDAO.findPersonById(id));
    }*/
    /*
    @PutMapping("Activity/{name}")
    public String changeActivity(@PathVariable String title, @RequestBody Activity activity){
        if(getPersonById(title) != null && activity.getTitle() == title){
            removeActivity(title);
            addActivity(activity);
            return "Activity replaced successfully";
        }
        else{
            return "This Activity does not exist in the DataBase";
        }
    }*/
}
