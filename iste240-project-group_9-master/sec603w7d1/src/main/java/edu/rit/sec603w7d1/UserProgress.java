package edu.rit.sec603w7d1;

public class UserProgress {
    private Long id;  // The unique ID for the UserProgress object
    private String userId; // A unique identifier for the user (e.g., username or email)
    private int totalPoints;  // Tracks the total points the user has earned
    private int articlesCompleted; // The number of articles the user has completed
    private long totalLearningTimeSeconds; // Total time the user has spent learning, in seconds

    // Default constructor (no-argument)
    public UserProgress() {}

    // Constructor that initializes a UserProgress object with a userId
    // Sets the initial values for points, completed articles, and learning time to 0
    public UserProgress(String userId) {
        this.userId = userId;  // Set the userId when creating the object
        this.totalPoints = 0;  // Initially, the user has 0 points
        this.articlesCompleted = 0;  // Initially, the user hasn't completed any articles
        this.totalLearningTimeSeconds = 0;  // Initially, the user hasn't spent any time learning
    }

    // Getters and Setters
    // These methods allow access and modification of the private fields

    public Long getId() {
        return id;  // Get the ID of the user progress record
    }

    public void setId(Long id) {
        this.id = id;  // Set the ID of the user progress record
    }

    public String getUserId() {
        return userId;  // Get the user ID
    }

    public void setUserId(String userId) {
        this.userId = userId;  // Set the user ID
    }

    public int getTotalPoints() {
        return totalPoints;  // Get the total points the user has earned
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;  // Set the total points for the user
    }

    public int getArticlesCompleted() {
        return articlesCompleted;  // Get the number of articles the user has completed
    }

    public void setArticlesCompleted(int articlesCompleted) {
        this.articlesCompleted = articlesCompleted;  // Set the number of articles completed
    }

    public long getTotalLearningTimeSeconds() {
        return totalLearningTimeSeconds;  // Get the total learning time in seconds
    }

    public void setTotalLearningTimeSeconds(long totalLearningTimeSeconds) {
        this.totalLearningTimeSeconds = totalLearningTimeSeconds;  // Set the total learning time in seconds
    }


    // These methods help update the user's progress as they earn points, complete articles, or spend more time learning

    public void addPoints(int points) {
        this.totalPoints += points;  // Add the given points to the user's total points
    }

    public void incrementArticlesCompleted() {
        this.articlesCompleted++;  // Increment the number of articles completed by 1
    }

    public void addLearningTime(long seconds) {
        this.totalLearningTimeSeconds += seconds;  // Add the given time (in seconds) to the user's total learning time
    }
}
