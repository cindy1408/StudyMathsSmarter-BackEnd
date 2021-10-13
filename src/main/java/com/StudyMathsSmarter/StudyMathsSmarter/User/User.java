package com.StudyMathsSmarter.StudyMathsSmarter.User;

import com.StudyMathsSmarter.StudyMathsSmarter.Quiz.Quiz;
import com.StudyMathsSmarter.StudyMathsSmarter.security.AppUserRole;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//user is a reserved name in db... hence can't be used!
@Entity(name = "Users")
@Table(name = "users")
public class User {
    @Id
    @SequenceGenerator( name="user_sequence",
                        sequenceName = "user_sequence",
                        allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE, generator = "user_sequence"
    )
    @Column(name ="id", updatable = false, nullable = false)
    private int id;
    @Column(name="first_name", nullable = false)
    private String firstName;
    @Column(name="last_name" , nullable = false)
    private String lastName;
    @Column(name="email" , nullable = false)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    //percentage
    @Column(name="score")
    private int score;
    @Column(name="role")
    private AppUserRole role;

    public User(@JsonProperty("first_name") String firstName,
                @JsonProperty("last_name") String lastName,
                @JsonProperty("email") String email,
                @JsonProperty("password") String password,
                @JsonProperty("score") int score,
                @JsonProperty("role") AppUserRole role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.score = score;
        this.role = role;
    }

    public User(String firstName, String lastName, String email, String password, AppUserRole role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AppUserRole getRole() {
        return role;
    }

    public void setRole(AppUserRole role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", score=" + score +
                ", role=" + role +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Double.compare(user.score, score) == 0 && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, password, score, role);
    }
}
