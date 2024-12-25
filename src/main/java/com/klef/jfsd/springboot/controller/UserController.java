package com.klef.jfsd.springboot.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.klef.jfsd.springboot.models.User;
import com.klef.jfsd.springboot.service.UserService;

@RestController
@RequestMapping("user")
@CrossOrigin(origins = "https://certification-management-sy-git-b29b9f-nikhil-maddelas-projects.vercel.app/") // Allow CORS for specific frontend origin

public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public String registerUser(@RequestParam("name") String name, 
                               @RequestParam("gender") String gender,
                               @RequestParam("email") String email, 
                               @RequestParam("password") String password, 
                               @RequestParam("contact") String contact,
                               @RequestParam(value = "profilePic", required = false) MultipartFile file) {

        User user = new User();
        user.setName(name);
        user.setGender(gender);
        user.setEmail(email);
        user.setPassword(password);
        user.setContact(contact);
        

        if (file != null) {
            try {
                user.setProfilepic(file.getBytes());
            } catch (IOException e) {
                return "Failed to upload profile picture";
            }
        }

        return service.UserRegistration(user);  
    }

    @PostMapping("/login")
    public User loginUser(@RequestBody User user) {
        return service.UserLogin(user.getEmail(), user.getPassword());
    }

    @PostMapping("/uploadProfilePic/{id}")
    public String uploadProfilePic(@PathVariable int id, @RequestParam("file") MultipartFile file) {
        try {
            return service.uploadProfilePic(id, file);
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to upload profile picture";
        }
    }

    @GetMapping("/profilepic/{id}")
    public ResponseEntity<byte[]> getProfilePic(@PathVariable int id) {
        User user = service.ProfilePic(id);
        return ResponseEntity.ok()
                             .contentType(MediaType.IMAGE_JPEG)
                             .body(user.getProfilepic());
    }
    
    @PostMapping("/changepassword")
    public String changePassword(@RequestParam String email, @RequestParam String oldPwd, @RequestParam String newPwd)
    {
    	return service.changePassword(email, oldPwd, newPwd);
    }
}
