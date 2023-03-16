package com.guciowons.footballguesser.Users.Authentication.Change;

import com.guciowons.footballguesser.Users.User;
import com.guciowons.footballguesser.Users.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserChangeService {
    private final UserRepository userRepository;

    public UserChangeService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User changePassword(String email, String oldPassword, String newPassword){
        return null;
    }

    public User changeEmail(String password, String oldEmail, String newEmail){
        return null;
    }

    public User changeUsername(String email, String password, String newUsername){
        return null;
    }
}
