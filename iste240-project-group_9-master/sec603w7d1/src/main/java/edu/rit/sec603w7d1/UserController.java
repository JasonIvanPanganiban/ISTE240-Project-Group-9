package edu.rit.sec603w7d1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;





@RequestMapping("/api/users")
// # All URLs in this controller will start with "/api/users"

public class UserController {
// # Define a public class named UserController

    private final UserService userService;
    // # Create a private variable for UserService (will handle the logic)

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    // # Constructor: Spring will automatically give (inject) us a UserService object

    // Get all users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
    // # Handle GET request to /api/users — return list of all users with HTTP 200 OK

    // Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    // # Handle GET /api/users/{id} — if user found, return it with 200 OK; else 404 Not Found

    // Create new user
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {
        try {
            User createdUser = userService.createUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create user");
        }
    }
    // # Handle POST /api/users — create a new user
    // # If success → 201 Created, if fail → 400 Bad Request

    // Update user
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody User user) {
        try {
            User updatedUser = userService.updateUser(id, user);
            return ResponseEntity.ok(updatedUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to update user");
        }
    }
    // # Handle PUT /api/users/{id} — update existing user
    // # If success → 200 OK, if fail → 400 Bad Request

    // Delete user
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to delete user");
        }
    }
    // # Handle DELETE /api/users/{id} — delete user
    // # If success → 204 No Content, if fail → 400 Bad Request
}
