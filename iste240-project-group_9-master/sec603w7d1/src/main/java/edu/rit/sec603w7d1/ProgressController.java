package edu.rit.sec603w7d1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// This class handles requests related to user progress (like how much progress they made)
@RestController  // This means the class is a "controller" that deals with the web requests
@RequestMapping("/api/v1/progress")  // All the requests here will start with "/api/v1/progress"
public class ProgressController {

    // This is the helper that works with user progress (it helps us get and update progress)
    @Autowired
    private UserProgressService progressService;

    // This method handles a GET request to get the user's progress
    // It looks up the user's progress using their userId and returns it
    @GetMapping("/{userId}")  // The URL will look like "/api/v1/progress/{userId}"
    public ResponseEntity<UserProgress> getUserProgress(@PathVariable String userId) {
        // Get the user's progress using the userId and return it
        return ResponseEntity.ok(progressService.getUserProgress(userId));
    }

    // This method handles a POST request to mark an article as complete for the user
    // It will add points and learning time to the user's progress
    @PostMapping("/{userId}/complete-article")  // The URL will look like "/api/v1/progress/{userId}/complete-article"
    public ResponseEntity<UserProgress> completeArticle(
            @PathVariable String userId,  // Get the userId from the URL
            @RequestParam int points,  // Get the points from the request
            @RequestParam long learningTimeSeconds) {  // Get the time spent learning in seconds
        // Complete the article for the user and return the updated progress
        return ResponseEntity.ok(
                progressService.completeArticle(userId, points, learningTimeSeconds)
        );
    }
}

