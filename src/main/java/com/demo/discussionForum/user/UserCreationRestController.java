package com.demo.discussionForum.user;

import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserCreationRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserCreationRestController.class);

    @Autowired
    private UserCreationService userCreationService;

    @PostMapping("/registration")
    public ResponseEntity<String> create(@Valid @RequestBody UserCreationForm userCreationForm,
        BindingResult bindingResult) {
    	LOGGER.error("{}", bindingResult);

        LOGGER.info("CREATE NEW USER: {}", userCreationForm.getUsername());
        userCreationService.create(userCreationForm.getNewUserEntity());
        return ResponseEntity.ok("User Created Successfully");
    }
}
