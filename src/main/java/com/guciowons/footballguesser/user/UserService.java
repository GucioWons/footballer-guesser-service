package com.guciowons.footballguesser.user;

import com.guciowons.footballguesser.user.User;
import com.guciowons.footballguesser.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getUserById(Integer userId){
        return userRepository.findById(userId);
    }
}
