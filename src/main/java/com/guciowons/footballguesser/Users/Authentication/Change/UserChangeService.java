package com.guciowons.footballguesser.Users.Authentication.Change;

import com.guciowons.footballguesser.Users.Authentication.Excepitons.IncorrectLoginException;
import com.guciowons.footballguesser.Users.User;
import com.guciowons.footballguesser.Users.UserRepository;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class UserChangeService {
    private final UserRepository userRepository;

    public UserChangeService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User changePassword(String email, String oldPassword, String newPassword){
        return userRepository.findByEmail(email)
                .filter(user -> BCrypt.checkpw(oldPassword, user.getPassword()))
                .map(user -> changePasswordAndSave(user, newPassword))
                .orElseThrow(() -> new IncorrectLoginException("Wrong password"));
    }

    private User changePasswordAndSave(User user, String newPassword){
        user.setPassword(BCrypt.hashpw(newPassword, BCrypt.gensalt()));
        return userRepository.save(user);
    }

    public User changeEmail(String password, String oldEmail, String newEmail){
        return userRepository.findByEmail(oldEmail)
                .filter(user -> BCrypt.checkpw(password, user.getPassword()))
                .map(user -> changeEmailAndSave(user, newEmail))
                .orElseThrow(() -> new IncorrectLoginException("Wrong password"));
    }

    private User changeEmailAndSave(User user, String newEmail){
        user.setEmail(newEmail);
        return userRepository.save(user);
    }

    public User changeUsername(String email, String password, String newUsername){
        return null;
    }
}
