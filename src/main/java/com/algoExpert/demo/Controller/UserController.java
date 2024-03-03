package com.algoExpert.demo.Controller;

import com.algoExpert.demo.Entity.User;
import com.algoExpert.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

//    create and save user
    @PostMapping("/saveUser")
    public User saveUser(@RequestBody User user){
        return userService.create(user);
    }

//    get all user from db
    @GetMapping("/getAllUsers")
    public List<User> getAll(){
        return userService.getUsers();
    }

//    get user by id
@GetMapping("/user/{user_id}")
public ResponseEntity<User> getUserById(@PathVariable Integer user_id) {
    Optional<User> userOptional = userService.findById(user_id);

    if (userOptional.isPresent()) {
        User user = userOptional.get();
        return new ResponseEntity<>(user, HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
    // Update user by id
	@PutMapping("/update/{user_id}")
	public User updateUser(@PathVariable Integer user_id, @RequestBody User updatedUser) {
        return userService.updateUser(user_id, updatedUser);
	}

//    @PutMapping("/update/{id}")
//    public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User updatedUser) {
//            userService.updateUser(id, updatedUser);
//        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
//    }

    // Delete user by id
    @DeleteMapping("/delete/{user_id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer user_id) {
        userService.deleteUser(user_id);
        return ResponseEntity.ok("User with ID " + user_id + " was deleted successfully.");
    }

}
