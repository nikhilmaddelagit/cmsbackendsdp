package com.klef.jfsd.springboot.service;


import org.springframework.web.multipart.MultipartFile;

import com.klef.jfsd.springboot.models.User;

public interface UserService 
{
	public String UserRegistration(User u);
    public User UserLogin(String email, String password);
    public User Contactus(String email, String message);
    public User ProfilePic(int id);
    public String uploadProfilePic(int id, MultipartFile file);
    
    public String changePassword(String email, String oldPwd, String newPwd);
    

}
