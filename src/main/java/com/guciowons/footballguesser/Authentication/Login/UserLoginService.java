package com.guciowons.footballguesser.Authentication.Login;

import com.guciowons.footballguesser.Authentication.User;
import com.guciowons.footballguesser.Authentication.UserRepository;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService {
    private final UserRepository userRepository;

    public UserLoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User loginUser(String email, String password) {
        return userRepository.findByEmail(email)
                .filter(user -> BCrypt.checkpw(password, user.getPassword()))
                .orElseThrow(() -> new RuntimeException("Incorrect email or password"));

    }
}
