package com.farm.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farm.entity.User;
import com.farm.register.UserModel;
import com.farm.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {
	
    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(UserModel userModel) {
        User user = new User();
        user.setEmail(userModel.getEmail());
        user.setFirstName(userModel.getFirstName());
        user.setLastName(userModel.getLastName());
        user.setAadharNo(userModel.getAadharNo());
        user.setDob(userModel.getDob());
        user.setId(userModel.getId());
        user.setPhoneNo(userModel.getPhoneNo());
        user.setVillage(userModel.getVillage());
        user.setState(userModel.getState());
        user.setPassword(userModel.getPassword()); // Assuming you want to store the password as-is
        userRepository.save(user);
        return user;
    }

    // Optional: If you want to retrieve a user by email without security
    public Optional<User> findByEmail(String email) {
        return Optional.ofNullable(userRepository.findByEmail(email));
    }

	@Override
	public User loginUser(String email, String password) {
               User user = userRepository.findByEmail(email);
        
        // Check if user exists and password matches
        if (user != null && user.getPassword().equals(password)) {
            return user; // Return user if credentials are valid
        } else {
            throw new RuntimeException("Invalid email or password."); // Throw exception if invalid
        }
	}

	
	
}
