package com.demo.discussionForum.user;

import com.demo.discussionForum.user.exception.UserNotFoundException;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserProfileService userProfileService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value="/user", method = RequestMethod.GET)
    public UserProfile findUserByUsernameAndViewProfilePage(@RequestParam("username") String username) {
        UserProfile userProfile;
        try {
            userProfile = userProfileService.findOne(username);
        } catch (NullPointerException e) {
            throw new UserNotFoundException();
        }
        return userProfile;
    }

    @GetMapping(value = "/users")
    public List<User> listOfAllUser() {
        return userService.findAll();       
    }

    @RequestMapping(value = "/myprofile")
    public String myProfile(Authentication authentication)
    {
        String username = authentication.getName();
        UserProfile userProfile;
        try {
            userProfile = userProfileService.findOne(username);
        } catch (NullPointerException e) {
            throw new UserNotFoundException();
        }
        return "user";
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User request) throws Exception {
        
    	User availableUser = userService.findByUsername(request.getUsername());
    	
    	if(availableUser == null || StringUtils.isEmpty(availableUser.getPassword())) {
    		return ResponseEntity.status(500).body("Unable to login");
    	}
    	if(passwordEncoder.matches(request.getPassword(), availableUser.getPassword())) {
    		return ResponseEntity.ok("logged in successfully");
    	}
    	
    	return ResponseEntity.status(500).body("Unable to login");
    }

    @RequestMapping(value = "/logout")
    public String logOutAndRedirectToLoginPage(Authentication authentication,
        HttpServletRequest request,
        HttpServletResponse response) {
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "Logged Out Successfully";
    }
}
