package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /*public User register(RegisterRequest request){

        if(userRepository.existsByUsername(request.username)){
            throw new RuntimeException("Username already exists");
        }

        User user = new User();
        user.setUsername(request.username);
        user.setEmail(request.email);
        user.setPassword(passwordEncoder.encode(request.password));
        user.setPhone(request.phone);
        user.setDate_age(request.date_age);
        user.setRole(request.role);
        user.setPassword(passwordEncoder.encode(request.password));

        return userRepository.save(user);

    }*/

    public List<User> getUsers(){
        return (List<User>) userRepository.findAll();
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public User getUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public User updateUser(Long id, User user){
        User existingUser = userRepository.findById(id).orElse(null);
        if(existingUser != null){
            existingUser.setUsername(user.getUsername());
            existingUser.setPassword(user.getPassword());
            existingUser.setEmail(user.getEmail());
            existingUser.setPhone(user.getPhone());
            existingUser.setDate_age(user.getDate_age());
            return userRepository.save(existingUser);
        }else{
            return null;
        }
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

}
