package com.klef.jfsd.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.klef.jfsd.springboot.models.Admin;
import com.klef.jfsd.springboot.models.Certificate;
import com.klef.jfsd.springboot.models.User;
import com.klef.jfsd.springboot.repository.CertificateRepository;
import com.klef.jfsd.springboot.repository.UserRepository;
import com.klef.jfsd.springboot.service.AdminService;


@Controller
@RequestMapping("/admin")
@CrossOrigin(origins = "https://certificationmanagementsystem.vercel.app") // Allow CORS for specific frontend origin

public class AdminController 
{
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private UserRepository service;
	
	@Autowired
	private CertificateRepository certificateRepository;
	
	@PostMapping("/adminlogin")
	public ResponseEntity<?> adminlogin(@RequestBody Admin admin) {
	    Admin loggedInAdmin = adminService.checkadminlogin(admin.getUname(), admin.getPwd());
	    if (loggedInAdmin == null) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
	    } else {
	        return ResponseEntity.ok(loggedInAdmin);
	    }
	}
	
	@GetMapping("/viewallusers")
	public ResponseEntity<?> viewAllUsers() 
	{
	    try 
	    {
	        List<User> userlist = adminService.viewAllUsers();
	        return ResponseEntity.ok(userlist);
	    } 
	    catch (Exception e) 
	    {
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while fetching users.");
	    }
	}
	
	@DeleteMapping("/admindeleteuser")
	public ResponseEntity<String> adminDeleteUser(@RequestParam("id") int u_id) 
	{
	    String result = adminService.deleteUser(u_id);
	    if (result.equals("User Deleted Successfully")) 
	    {
	        return ResponseEntity.ok(result);
	    } 
	    else 
	    {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
	    }
	}
	
	 @GetMapping("/adminviewcerti")
	    public ResponseEntity<List<Certificate>> viewAllCertificates() {
	        List<Certificate> certificates = service.ViewAllCertificates();
	        System.out.println(certificates.size());
	        return ResponseEntity.ok(certificates);
	    }
	    
	    @GetMapping("/getcertificate/{id}")
	    public ResponseEntity<byte[]> getCertificateById(@PathVariable int id) {
	        Certificate cert = service.ViewCertiByID(id);
	        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(cert.getImageData());
	    }    
	    
	   


}
