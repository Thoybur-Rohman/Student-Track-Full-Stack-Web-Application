package com.Thoybur.fullStackbackEnd.controller;


import com.Thoybur.fullStackbackEnd.exception.UserNotFoundException;
import com.Thoybur.fullStackbackEnd.model.User;
import com.Thoybur.fullStackbackEnd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


// @RestController is used to create a rest controller
// a rest controller is used to create a rest api which is used to communicate with the front end
@RestController
// @CrossOrigin is used to allow cross origin requests which is used to allow requests from different domains to access the api
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    //@Autowired is used to inject the dependency
    //dependency injection is used to inject the dependency into the class
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    User newUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/users")
    Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
        // @PathVariable is used to get the value of the path variable
        //this method is used to get a user by id
    User getUser(@PathVariable Long id) {
        return userRepository.findById(id).
                orElseThrow(() -> new UserNotFoundException(id));

        //orElseThrow(() is a method that is used to throw an exception if the user is not found
    }

    // @PutMapping is used to update a user
    @PutMapping("/user/{id}")
    //this method is used to update a user
    User updateUser(@RequestBody User newUser, @PathVariable Long id) {
        return userRepository.findById(id)
                //map is used to map the user to the new user
                //map creates a new array
                // creates a new array with the results of calling a function for every array element
                .map(user -> {
                    user.setName(newUser.getName());
                    //newUser.getName() is used to get the name of the new user
                    user.setUserName(newUser.getUserName());
                    user.setEmail(newUser.getEmail());
                    //save is used to save the user to the database
                    return userRepository.save(user);
                })
                .orElseThrow(() -> new UserNotFoundException(id));

    }

    // @DeleteMapping is used to delete a user
    @DeleteMapping("/user/{id}")
    //this method is used to delete a user
    void deleteUser(@PathVariable Long id) {

        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new UserNotFoundException(id);
        }
    }
    //existsById is used to check if the user exists
}
