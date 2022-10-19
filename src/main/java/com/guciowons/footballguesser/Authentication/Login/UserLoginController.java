package com.guciowons.footballguesser.Authentication.Login;

import com.guciowons.footballguesser.Authentication.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserLoginController {
    private final UserLoginService userLoginService;

    public UserLoginController(UserLoginService userLoginService) {
        this.userLoginService = userLoginService;
    }

    @PostMapping(value = "/login")
    public ResponseEntity<User> loginUser(@RequestBody Login login){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userLoginService.loginUser(login));
    }
}
