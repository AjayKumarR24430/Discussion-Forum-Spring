package com.demo.discussionForum.exceptions;

public class UserException extends RuntimeException{
    public UserException(final String userNotFound) {
        super(userNotFound);
    }
}