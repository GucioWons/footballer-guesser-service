package com.guciowons.footballguesser.Users.Authentication.Change;

import com.guciowons.footballguesser.Users.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserChangeController {
    private final UserChangeService userChangeService;

    public UserChangeController(UserChangeService userChangeService) {
        this.userChangeService = userChangeService;
    }

    public ResponseEntity<User> changePassword(String email, String oldPassword, String newPassword){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userChangeService.changePassword(email, oldPassword, newPassword));
    }

    public ResponseEntity<User> changeEmail(String password, String oldEmail, String newEmail){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userChangeService.changeEmail(password, oldEmail, newEmail));
    }

    public ResponseEntity<User> changeUsername(String email, String password, String newUsername){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userChangeService.changeUsername(email, password, newUsername));
    }
}
