package com.demo.discussionForum.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Section does not exist!")
public class SectionNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -1588022872179092062L;
}



