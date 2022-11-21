package com.guciowons.footballguesser.Users.Authentication.Register;

import com.guciowons.footballguesser.Users.Authentication.Excepitons.EmailExistsException;
import com.guciowons.footballguesser.Users.Authentication.Excepitons.EmptyParamsException;
import com.guciowons.footballguesser.Users.Authentication.Excepitons.UsernameExistsException;
import com.guciowons.footballguesser.Users.User;
import com.guciowons.footballguesser.Users.UserRepository;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserRegisterService {
    private final UserRepository userRepository;

    public UserRegisterService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(Register register) {
        if(register.getUsername().isEmpty() || register.getEmail().isEmpty() || register.getPassword().isEmpty()){
            throw new EmptyParamsException("You have to pass all params");
        }
        if(userRepository.existsByEmail(register.getEmail())){
            throw new EmailExistsException("Email is already taken");
        }
        if(userRepository.existsByUsername(register.getUsername())){
            throw new UsernameExistsException("Username is already taken");
        }
        return userRepository.save(new User(register.getUsername(), register.getEmail(), BCrypt.hashpw(register.getPassword(), BCrypt.gensalt()), true, LocalDateTime.now()));
    }
}
