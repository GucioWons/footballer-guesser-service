package com.guciowons.footballguesser.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticateDTO> register(@RequestBody UserDTO register){
        return ResponseEntity.status(HttpStatus.CREATED).body(authenticationService.register(register));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticateDTO> authenticate(@RequestBody UserDTO auth){
        return ResponseEntity.status(HttpStatus.OK).body(authenticationService.authenticate(auth));
    }
}
