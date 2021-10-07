package com.StudyMathsSmarter.StudyMathsSmarter.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RequestMapping("study_maths_smarter/user")
@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> userFullList(){
        return userService.userFullList();
    }

    @GetMapping("/{userId}")
    public Optional<User> getUser(int userId){
        return userService.getUser(userId);
    }

    @PostMapping
    public void addNewUser(User newUser){
        userService.addNewUser(newUser);
    }

    @PutMapping
    public void updateUser(String userEmail, String columnToUpdate, String valueToUpdate){
        userService.updateUser(userEmail, columnToUpdate, valueToUpdate);
    }

    @DeleteMapping
    public void deleteUser(String userEmail){
        userService.deleteUser(userEmail);
    }


}
