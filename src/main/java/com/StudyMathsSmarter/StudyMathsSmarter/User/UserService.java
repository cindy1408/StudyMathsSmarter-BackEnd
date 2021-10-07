package com.StudyMathsSmarter.StudyMathsSmarter.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepositoryPostgres userRepositoryPostgres;

    @Autowired
    public UserService(UserRepositoryPostgres userRepositoryPostgres) {
        this.userRepositoryPostgres = userRepositoryPostgres;
    }

    //GET REQUEST
    public List<User> userFullList(){
        return userRepositoryPostgres.findAll();
    }
    // GET REQUEST
    public Optional<User> getUser(int userId){
        return userRepositoryPostgres.findById(userId);
    }

    //POST REQUEST
    public void addNewUser (User newUser){
        userRepositoryPostgres.findUserByEmail(newUser.getEmail())
                .ifPresentOrElse(user -> {
                    System.out.println("Your email address is already registered.");
                }, () -> {
                    userRepositoryPostgres.save(newUser);
                });
    }

    //PUT REQUEST
    public void updateUser(String userEmail, String columnToUpdate, String valueToUpdate){
        userRepositoryPostgres.findUserByEmail(userEmail)
                .ifPresentOrElse(user -> {
                            switch (columnToUpdate) {
                                case "first_name" -> {
                                    user.setFirstName(valueToUpdate);
                                    userRepositoryPostgres.save(user);
                                }
                                case "last_name" -> {
                                    user.setLastName(valueToUpdate);
                                    userRepositoryPostgres.save(user);
                                }
                                case "email" -> {
                                    user.setEmail(valueToUpdate);
                                    userRepositoryPostgres.save(user);
                                }
                                default -> System.out.println("Invalid column name");
                            }
                        },
                        () -> System.out.println("user email not found")

                );
    }

    //DELETE REQUEST
    public void deleteUser(String userEmail){
        userRepositoryPostgres.findUserByEmail(userEmail)
                .ifPresentOrElse(userRepositoryPostgres::delete, () -> System.out.println("cannot find user by email"));
    }

}
