package com.StudyMathsSmarter.StudyMathsSmarter.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    //POST REQUEST
    public void addNewUser (User newUser){
        userRepositoryPostgres.findUserByEmail(newUser.getEmail())
                .ifPresentOrElse(user -> {
                    System.out.println("Your email address is already regsitered.");
                }, () -> {
                    userRepositoryPostgres.save(newUser);
                });
    }

    //PUT REQUEST


}
