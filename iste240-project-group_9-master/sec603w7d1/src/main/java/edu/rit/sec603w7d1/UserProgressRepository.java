package edu.rit.sec603w7d1;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository  // This marks the class as a special helper that works with user progress
public class UserProgressRepository {

    // A list to store all the user progress data (like a collection of all the user's scores)
    private List<UserProgress> progressList = new ArrayList<>();

    // The constructor sets up a default user (user1) with no points and no articles completed
    public UserProgressRepository() {

        // Create a default progress for user "user1"
        UserProgress defaultProgress = new UserProgress("user1");
        defaultProgress.setTotalPoints(0);  // Set their points to 0
        defaultProgress.setArticlesCompleted(0);  // Set articles completed to 0
        defaultProgress.setTotalLearningTimeSeconds(0);  // Set learning time to 0 seconds

        // Add this default progress for "user1" to the list of progress
        progressList.add(defaultProgress);
    }

    // This method saves a user's progress. It will either update their progress or add new progress
    public UserProgress save(UserProgress progress) {

        // First, check if the user already has progress saved
        Optional<UserProgress> existingProgress = findByUserId(progress.getUserId());
        if (existingProgress.isPresent()) {
            // If the user is found, update their progress in the list
            int index = progressList.indexOf(existingProgress.get());  // Find the spot where the user is
            progressList.set(index, progress);  // Replace the old progress with the new one
        } else {
            // If the user isn't found, add their new progress to the list
            progressList.add(progress);
        }
        return progress;  // Return the saved (or updated) progress
    }

    // This method finds a user's progress by their unique userId
    public Optional<UserProgress> findByUserId(String userId) {

        // Go through the list of all progress and look for the one that matches the userId
        return progressList.stream()
                .filter(progress -> progress.getUserId().equals(userId))  // Look for a match
                .findFirst();  // Return the first match, if there is one
    }
}

