package com.guciowons.footballguesser.Authentication.Register;

import com.guciowons.footballguesser.Authentication.User;
import com.guciowons.footballguesser.Authentication.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserRegisterService {
    private final UserRepository userRepository;

    public UserRegisterService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String username, String email, String password) {
        return userRepository.save(new User(username, email, password));
    }
}
