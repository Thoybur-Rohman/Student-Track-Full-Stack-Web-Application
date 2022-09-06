package com.Thoybur.fullStackbackEnd.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        //super is used to call the constructor of the parent class
        //super means the parent class
        super("Could not find user " + id);
    }

}