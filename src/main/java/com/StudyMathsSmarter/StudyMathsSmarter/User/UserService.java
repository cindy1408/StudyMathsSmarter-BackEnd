package com.StudyMathsSmarter.StudyMathsSmarter.User;

import com.StudyMathsSmarter.StudyMathsSmarter.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
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
    public void updateUser(int userId, String columnToUpdate, String valueToUpdate){
        userRepositoryPostgres.findById(userId)
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
    public void deleteUser(int userId){
        userRepositoryPostgres.findById(userId)
                .ifPresentOrElse(userRepositoryPostgres::delete, () -> System.out.println("cannot find user by email"));
    }

    public List<User> getTopTen(){
        return userRepositoryPostgres.findTopTen().stream().limit(10).toList();
    }

//    public void login(String email, String password){
//        Optional<User> user = userRepositoryPostgres.findUserByEmail(email);
//        if (user.isEmpty()){
//            throw new NotFoundException("user email or password incorrect");
//        }
//
//        if (!passwordCheck(password, user.get().getPassword())){
//            throw new NotFoundException("user email or password incorrect");
//        }
//    }
//
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(10, new SecureRandom());
    }

    public static boolean passwordCheck(String password, String encodedPassword){
        return passwordEncoder().matches(password, encodedPassword);
    }
}
