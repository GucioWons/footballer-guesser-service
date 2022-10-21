package com.guciowons.footballguesser.Users.Authentication.Login;

import com.guciowons.footballguesser.Users.Authentication.Excepitons.IncorrectLoginException;
import com.guciowons.footballguesser.Users.User;
import com.guciowons.footballguesser.Users.UserRepository;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService {
    private final UserRepository userRepository;

    public UserLoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User loginUser(Login login) {
        return userRepository.findByEmail(login.getEmail())
                .filter(user -> BCrypt.checkpw(login.getPassword(), user.getPassword()))
                .orElseThrow(() -> new IncorrectLoginException("Incorrect email or password"));
    }
}
