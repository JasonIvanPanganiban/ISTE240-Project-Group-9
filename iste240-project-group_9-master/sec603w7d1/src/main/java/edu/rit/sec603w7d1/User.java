package edu.rit.sec603w7d1;


import jakarta.persistence.*;


import lombok.Data;


@Entity
@Table(name = "users")
@Data
//automatically creates getters, setters, equals, hashCode, and toString methods

public class User {
// # Define a public class called User

    @Id
    // # Marks 'id' as the primary key for this entity

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // # Database will auto-generate the ID value

    private Long id;
    // # A private field 'id' of type Long

    @Column(nullable = false, unique = true)
    // # Maps 'username' to a database column that must be unique and cannot be null

    private String username;
    // # stores the user's username

    @Column(nullable = false, unique = true)
    // # email  must be unique and cannot be null

    private String email;
    // stores the user's email address

    @Column(nullable = false)
    // # Maps password to a database column that cannot be null, it cannot be unique, alot of users can have the same password technically)

    private String password;
    // # A private field 'password' of type String (stores the user's password)
}
