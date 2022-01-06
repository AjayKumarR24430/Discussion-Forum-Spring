package com.demo.discussionForum.exceptions;

public class CommentException extends RuntimeException {
    public CommentException(final String commentNotFound) {
        super(commentNotFound);
    }
}
