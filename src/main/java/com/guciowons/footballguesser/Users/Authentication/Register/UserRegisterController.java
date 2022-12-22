package com.guciowons.footballguesser.Users.Authentication.Register;

import com.guciowons.footballguesser.Users.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRegisterController {
    private final UserRegisterService userRegisterService;

    public UserRegisterController(UserRegisterService userRegisterService) {
        this.userRegisterService = userRegisterService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody Register register){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userRegisterService.createUser(register));
    }
}
