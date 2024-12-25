package com.klef.jfsd.springboot.service;

import java.util.List;

import com.klef.jfsd.springboot.models.Admin;
import com.klef.jfsd.springboot.models.Certificate;
import com.klef.jfsd.springboot.models.User;

public interface AdminService 
{
	public Admin checkadminlogin(String uname, String pwd);
	public List<User> viewAllUsers();
	public String deleteUser(int u_id);
	public List<Certificate> ViewAllCertificates();
	public Certificate ViewCertiByID(int certiid);
	
	


}
