package com.guciowons.footballguesser.auth;

import com.guciowons.footballguesser.config.JwtService;
import com.guciowons.footballguesser.users.Role;
import com.guciowons.footballguesser.users.User;
import com.guciowons.footballguesser.users.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticateDTO register(UserDTO register) {
        User user = new User(register.username(), register.email(), passwordEncoder.encode(register.password()),
                true, LocalDateTime.now());
        user.setRole(Role.Admin);
        userRepository.save(user);
        return new AuthenticateDTO(user.getUsername(), user.getEmail(), user.getPassword(), jwtService.generateToken(user));
    }

    public AuthenticateDTO authenticate(UserDTO auth) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(auth.username(), auth.password()));
        User user = userRepository.findByUsername(auth.username())
                .orElseThrow(() -> new UsernameNotFoundException("DUPA"));
        return new AuthenticateDTO(user.getUsername(), user.getEmail(), user.getPassword(), jwtService.generateToken(user));
    }
}
