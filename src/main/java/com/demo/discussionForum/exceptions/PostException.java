package com.demo.discussionForum.exceptions;

public class PostException extends RuntimeException {
    public PostException(final String postNotFound) {
        super(postNotFound);
    }
}