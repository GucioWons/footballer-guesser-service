package com.guciowons.footballguesser.Users.Authentication.Register;

import com.guciowons.footballguesser.Users.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRegisterController {
    private final UserRegisterService userRegisterService;

    public UserRegisterController(UserRegisterService userRegisterService) {
        this.userRegisterService = userRegisterService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestParam String username,
                                             @RequestParam String email,
                                             @RequestParam String password){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userRegisterService.createUser(username, email, BCrypt.hashpw(password, BCrypt.gensalt())));
    }
}