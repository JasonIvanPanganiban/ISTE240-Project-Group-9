package edu.rit.sec603w7d1;


import edu.rit.sec603w7d1.User;
import edu.rit.sec603w7d1.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;


@Service

public class UserService {
// # Start of the UserService class

    private final UserRepository userRepository;
    // # Variable to access UserRepository methods (like save, find, delete)

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    // # Constructor: Spring will inject a real UserRepository when this class is created

    // Find all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    // # Get all users from the database

    // Find user by ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
    // # Get one user by their ID (maybe user exists, maybe not)

    // Find user by username
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    // # Get one user by their username

    // Find user by email
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    // # Get one user by their email address

    // Search users by keyword
    public List<User> searchUsers(String keyword) {
        return userRepository.searchByKeyword(keyword);
    }
    // # Search users by a keyword (could be part of username or email)

    // Create new user
    @Transactional
    public User createUser(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new IllegalArgumentException("Username already exists");
        }
        // # Check: If username already taken, throw an error

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }
        // # Check: If email already taken, throw an error

        return userRepository.save(user);
        // # Save new user into database and return it
    }

    // Update existing user
    @Transactional
    public User updateUser(Long id, User updatedUser) {
        return userRepository.findById(id)
                .map(existingUser -> {
                    // # If user found, update details inside this block

                    if (!existingUser.getUsername().equals(updatedUser.getUsername()) &&
                            userRepository.existsByUsername(updatedUser.getUsername())) {
                        throw new IllegalArgumentException("Username already exists");
                    }
                    // # If new username is different and already taken by someone else, throw error

                    if (!existingUser.getEmail().equals(updatedUser.getEmail()) &&
                            userRepository.existsByEmail(updatedUser.getEmail())) {
                        throw new IllegalArgumentException("Email already exists");
                    }
                    // # If new email is different and already taken, throw error

                    existingUser.setUsername(updatedUser.getUsername());
                    existingUser.setEmail(updatedUser.getEmail());
                    existingUser.setPassword(updatedUser.getPassword());
                    // # Update username, email, and password

                    return userRepository.save(existingUser);
                    // # Save updated user into database
                })
                .orElseThrow(() -> new IllegalArgumentException("User with ID " + id + " not found"));
        // # If user with the given id not found, throw error
    }

    // Delete user
    @Transactional
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new IllegalArgumentException("User with ID " + id + " not found");
        }
        // # If user doesn't exist, throw error

        userRepository.deleteById(id);
        // # If exists, delete the user
    }
}
