package com.guciowons.footballguesser.Users.Authentication.Change;

import com.guciowons.footballguesser.Users.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/change")
public class UserChangeController {
    private final UserChangeService userChangeService;

    public UserChangeController(UserChangeService userChangeService) {
        this.userChangeService = userChangeService;
    }

    @PostMapping("/password")
    public ResponseEntity<User> changePassword(@RequestParam String email, @RequestParam String oldPassword, @RequestParam String newPassword){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userChangeService.changePassword(email, oldPassword, newPassword));
    }

    @PostMapping("/email")
    public ResponseEntity<User> changeEmail(@RequestParam String password, @RequestParam String oldEmail, @RequestParam String newEmail){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userChangeService.changeEmail(password, oldEmail, newEmail));
    }

    @PostMapping("/username")
    public ResponseEntity<User> changeUsername(@RequestParam String email, @RequestParam String password, @RequestParam String newUsername){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userChangeService.changeUsername(email, password, newUsername));
    }
}
