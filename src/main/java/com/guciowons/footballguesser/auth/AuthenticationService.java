package com.guciowons.footballguesser.auth;

import com.guciowons.footballguesser.auth.dto.AuthenticateDTO;
import com.guciowons.footballguesser.auth.dto.RegisterDTO;
import com.guciowons.footballguesser.auth.dto.UserResponseDTO;
import com.guciowons.footballguesser.config.jwt.JwtService;
import com.guciowons.footballguesser.user.Role;
import com.guciowons.footballguesser.user.User;
import com.guciowons.footballguesser.user.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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

    public UserResponseDTO register(RegisterDTO register) {
        User user = new User(register.username(), register.email(), passwordEncoder.encode(register.password()),
                true, LocalDateTime.now());
        user.setRole(Role.Admin);
        userRepository.save(user);
        return new UserResponseDTO(user.getUsername(), user.getEmail(), user.getPassword(), jwtService.generateToken(user));
    }

    public UserResponseDTO authenticate(AuthenticateDTO auth) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(auth.login(), auth.password()));
        User user = userRepository.findByUsername(auth.login())
                .orElseThrow(() -> new UsernameNotFoundException("DUPA"));
        return new UserResponseDTO(user.getUsername(), user.getEmail(), user.getPassword(), jwtService.generateToken(user));
    }
}
