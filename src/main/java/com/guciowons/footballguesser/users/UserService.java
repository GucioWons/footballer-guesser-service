package com.guciowons.footballguesser.users;

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
