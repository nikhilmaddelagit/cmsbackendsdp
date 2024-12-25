package com.klef.jfsd.springboot.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.klef.jfsd.springboot.models.User;
import com.klef.jfsd.springboot.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public String UserRegistration(User u) {
        userRepository.save(u);
        return "User Registered Successfully";
    }

    @Override
    public User UserLogin(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

	@Override
	public User Contactus(String email, String message) {
		// TODO Auto-generated method stub
		return null;
	}

	 @Override
	    public User ProfilePic(int id) {
	        return userRepository.findById(id).orElse(null);
	    }

	    @Override
	    public String uploadProfilePic(int id, MultipartFile file) {
	        try {
	            User user = userRepository.findById(id).orElse(null);
	            if (user == null) {
	                return "User not found";
	            }

	            user.setProfilepic(file.getBytes()); 
	            userRepository.save(user); 

	            return "Profile picture uploaded successfully";
	        } catch (IOException e) {
	            e.printStackTrace();
	            return "Failed to upload profile picture";
	        }
	    }

		@Override
		public String changePassword(String email, String oldPwd, String newPwd) 
		{
			User user = userRepository.findByEmail(email);
			
			if(user==null)
			{
				return "user not found";
			}
			
			if(!user.getPassword().equals(oldPwd))
			{
				return "Old Password Is Incorrect";
			}
			
			user.setPassword(newPwd);
			userRepository.save(user);
			
			return "Password Changed Successfully!!";
		}
	}
