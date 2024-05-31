package com.project.Login.Register.service.Imp;

import com.project.Login.Register.repository.UserRepository;
import com.project.Login.Register.model.User;
import com.project.Login.Register.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> userLogin(User user) {
         Optional<User> Optionaluser=userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
         return Optionaluser;
    }
}
