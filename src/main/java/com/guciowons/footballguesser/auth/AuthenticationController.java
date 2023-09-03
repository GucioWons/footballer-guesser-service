package com.guciowons.footballguesser.auth;

import com.guciowons.footballguesser.auth.dto.AuthenticateDTO;
import com.guciowons.footballguesser.auth.dto.RegisterDTO;
import com.guciowons.footballguesser.auth.dto.UserResponseDTO;
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
    public ResponseEntity<UserResponseDTO> register(@RequestBody RegisterDTO register){
        return ResponseEntity.status(HttpStatus.CREATED).body(authenticationService.register(register));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<UserResponseDTO> authenticate(@RequestBody AuthenticateDTO auth){
        return ResponseEntity.status(HttpStatus.OK).body(authenticationService.authenticate(auth));
    }
}
