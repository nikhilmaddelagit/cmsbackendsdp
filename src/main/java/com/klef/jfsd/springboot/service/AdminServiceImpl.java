package com.klef.jfsd.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.models.Admin;
import com.klef.jfsd.springboot.models.Certificate;
import com.klef.jfsd.springboot.models.User;
import com.klef.jfsd.springboot.repository.AdminRepository;
import com.klef.jfsd.springboot.repository.CertificateRepository;
import com.klef.jfsd.springboot.repository.UserRepository;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private CertificateRepository certificateRepository;

	@Override
	public Admin checkadminlogin(String uname, String pwd) {
		return adminRepository.findByUnameAndPwd(uname, pwd);
	}



	@Override
    public List<User> viewAllUsers() 
	{
        return  userRepository.findAll();
    }



	@Override
	public String deleteUser(int u_id) 
	{
		Optional<User> obj =  userRepository.findById(u_id); 
		String msg = null;
		
		
		if(obj.isPresent())
		{
			User u = obj.get();
			userRepository.delete(u);
			  msg = "User Deleted Successfully";

		}
		else
		  {
			  msg = "User ID Not Found";
		  }
		  return msg;
	}


	@Override
	public List<Certificate> ViewAllCertificates() 
	{
		List<Certificate> c=(List<Certificate>) certificateRepository.findAll();
		System.out.println(c);
		return c;
		

	}


	@Override
	public Certificate ViewCertiByID(int certiid) 
	{
		return certificateRepository.findById(certiid).get();

	}







	


}