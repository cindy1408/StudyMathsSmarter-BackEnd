package com.StudyMathsSmarter.StudyMathsSmarter.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
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

    public User getUserByEmail(String username){
        Optional<User> user = userRepositoryPostgres.findUserByEmail(username);
        if (user.isEmpty()){
            throw new UsernameNotFoundException("username or password not found");
        }

        return user.get();
    }

    public List<User> getTopTen(){
        return userRepositoryPostgres.findTopTen().stream().limit(10).toList();
    }

    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(10, new SecureRandom());
    }

    public static boolean passwordCheck(String password, String encodedPassword){
        return passwordEncoder().matches(password, encodedPassword);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = getUserByEmail(username);

        org.springframework.security.core.userdetails.User.UserBuilder builder = null;
        builder = org.springframework.security.core.userdetails.User.withUsername(username);
        builder.password(user.getPassword());
        builder.roles(user.getRole().toString());

        return builder==null ? null : builder.build();
    }
}
