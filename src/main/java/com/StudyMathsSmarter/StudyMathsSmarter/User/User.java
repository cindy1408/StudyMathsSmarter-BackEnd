package com.StudyMathsSmarter.StudyMathsSmarter.User;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import java.util.Objects;

//user is a reserved name in db... hence can't be used!
@Entity(name = "Users")
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(name ="email", columnNames = "email")
})
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
    @Column(name="score")
    private int score;

    public User(@JsonProperty("first_name") String firstName,
                @JsonProperty("last_name") String lastName,
                @JsonProperty("email") String email,
                @JsonProperty("score") int score) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.score = score;
    }

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && score == user.score && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, score);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", score=" + score +
                '}';
    }
}
