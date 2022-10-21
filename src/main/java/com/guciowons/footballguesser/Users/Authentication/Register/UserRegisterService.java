package com.guciowons.footballguesser.Users.Authentication.Register;

import com.guciowons.footballguesser.Users.Authentication.Excepitons.EmailExistsException;
import com.guciowons.footballguesser.Users.Authentication.Excepitons.EmptyParamsException;
import com.guciowons.footballguesser.Users.Authentication.Excepitons.UsernameExistsException;
import com.guciowons.footballguesser.Users.User;
import com.guciowons.footballguesser.Users.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserRegisterService {
    private final UserRepository userRepository;

    public UserRegisterService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String username, String email, String password) {
        if(username.isEmpty() || email.isEmpty() || password.isEmpty()){
            throw new EmptyParamsException("You have to pass all params");
        }
        if(userRepository.existsByEmail(email)){
            throw new EmailExistsException("Email is already taken");
        }
        if(userRepository.existsByUsername(username)){
            throw new UsernameExistsException("Username is already taken");
        }
        return userRepository.save(new User(username, email, password, true, LocalDateTime.now()));
    }
}
