package com.algoExpert.demo.Service;

import com.algoExpert.demo.Entity.*;
import com.algoExpert.demo.Repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // create new user
    public User create(User user) {
        return (User) userRepository.save(user);
    }

//random users generator( use once)

//    @PostConstruct
//    public List<User> createUsers(){
//
//        List<User> users = IntStream.
//                range(1,10)
//                .mapToObj(i ->new User(0,"user"+i,"email@gmail.com"+i,null,null,null))
//                .collect(Collectors.toList());
//       return userRepository.saveAll(users);
//    }

    // gets all users
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    // get user by id
    public Optional<User> findById(Integer user_id) {
        return userRepository.findById(user_id);
    }

    // Update user by id
    public User updateUser(Integer user_id, User updatedUser) {
        Optional<User> optionalUser = userRepository.findById(user_id);

        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            // Update the fields you want to change
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setEmail(updatedUser.getEmail());
            // Update other fields as needed

            // Save and return the updated user
            return userRepository.save(existingUser);
        } else {
            // Handle the case where the user with the given id is not found
            // You can throw an exception, return a specific response, etc.
            // For simplicity, let's throw an IllegalArgumentException
            throw new IllegalArgumentException("User not found with id: " + user_id);
        }
    }

    // Delete user by id
    public List<User> deleteUser(int user_id){
        userRepository.deleteById(user_id);
        return userRepository.findAll();
    }

    //    public List<Comment> userComments(int userId){
//        User findUser = userRepository.findById(userId).orElseThrow();
//        return findUser.getComments();
//    }

}
