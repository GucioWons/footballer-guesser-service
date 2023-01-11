package com.guciowons.footballguesser.Health;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping
    public ResponseEntity<String> checkHealth(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Everything fine");
    }
}
