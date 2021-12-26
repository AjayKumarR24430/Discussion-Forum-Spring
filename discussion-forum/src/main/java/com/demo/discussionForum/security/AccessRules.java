package com.demo.discussionForum.security;

public class AccessRules {

    protected static final String[] FOR_EVERYONE = {
        "/error",
        "/users/**",
        "/users/registration",
        "/section/new",
        "/user/**",
        "/topic/new/**",
        "/topic/delete/**",
        "/section/delete/**",
        "/section/new/**",
        "/post/**",
        "/myprofile/**"
    };

}
