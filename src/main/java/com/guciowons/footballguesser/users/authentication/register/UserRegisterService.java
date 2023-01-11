package com.guciowons.footballguesser.users.authentication.register;

import com.guciowons.footballguesser.excepitons.authentication.EmailExistsException;
import com.guciowons.footballguesser.excepitons.authentication.EmptyParamsException;
import com.guciowons.footballguesser.excepitons.authentication.UsernameExistsException;
import com.guciowons.footballguesser.users.User;
import com.guciowons.footballguesser.users.UserRepository;
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
