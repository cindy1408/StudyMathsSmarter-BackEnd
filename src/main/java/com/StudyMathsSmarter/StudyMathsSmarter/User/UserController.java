package com.StudyMathsSmarter.StudyMathsSmarter.User;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    public Optional<User> getUser(@PathVariable int userId){
        return userService.getUser(userId);
    }

    @PostMapping
    public void addNewUser(@RequestBody User newUser){
        userService.addNewUser(newUser);
    }

    @PutMapping("{userId}/{columnToUpdate}/{valueToUpdate}")
    public void updateUser(@PathVariable int userId, @PathVariable String columnToUpdate, @PathVariable String valueToUpdate){
        userService.updateUser(userId, columnToUpdate, valueToUpdate);
    }

    @DeleteMapping("{userId}")
    public void deleteUser(@PathVariable int userId){
        userService.deleteUser(userId);
    }

    @GetMapping("rank")
    public List<User> findTopTen(){
        return userService.getTopTen();
    }

}
