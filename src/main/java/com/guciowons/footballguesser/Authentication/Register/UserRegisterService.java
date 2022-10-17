package com.guciowons.footballguesser.Authentication.Register;

import com.guciowons.footballguesser.Authentication.User;
import org.springframework.stereotype.Service;

@Service
public class UserRegisterService {
    public User createUser(String username, String email, String password) {
        return new User(username, email, password);
    }
}
