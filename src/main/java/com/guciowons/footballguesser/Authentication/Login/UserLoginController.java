package com.guciowons.footballguesser.Authentication.Login;

import com.guciowons.footballguesser.Authentication.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserLoginController {
    private final UserLoginService userLoginService;

    public UserLoginController(UserLoginService userLoginService) {
        this.userLoginService = userLoginService;
    }

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestParam String email,
                                          @RequestParam String password){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userLoginService.loginUser(email, password));
    }
}
