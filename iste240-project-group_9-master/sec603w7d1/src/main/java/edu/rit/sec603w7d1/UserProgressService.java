package edu.rit.sec603w7d1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service  // This marks the class as a special helper service for working with user progress
public class UserProgressService {

    // This is the helper that talks to the database or list where user progress is stored
    @Autowired
    private UserProgressRepository progressRepository;

    // This method gets the user's progress by their userId
    // If the user is not found, it creates a new blank progress for that user
    public UserProgress getUserProgress(String userId) {
        return progressRepository.findByUserId(userId)
                .orElse(new UserProgress(userId));  // If user isn't found, create a new progress
    }

    // This method updates the user's progress when they finish an article
    // It adds points, increments the articles completed, and adds learning time
    public UserProgress completeArticle(String userId, int pointsEarned, long learningTimeSeconds) {
        // First, get the user's current progress
        UserProgress progress = getUserProgress(userId);
        // Increase the count of completed articles
        progress.incrementArticlesCompleted();
        // Add the points earned for completing the article
        progress.addPoints(pointsEarned);
        // Add the time spent learning
        progress.addLearningTime(learningTimeSeconds);
        // Save the updated progress back to the repository (list or database)
        return progressRepository.save(progress);
    }

    // This method calculates the total learning time in hours
    // It takes the total learning time in seconds and converts it to hours
    public double getTotalLearningTimeHours(String userId) {
        // Get the user's progress
        UserProgress progress = getUserProgress(userId);
        // Convert seconds into hours (3600 seconds = 1 hour)
        return progress.getTotalLearningTimeSeconds() / 3600.0;
    }
}
