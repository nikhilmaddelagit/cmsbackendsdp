package com.klef.jfsd.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.klef.jfsd.springboot.models.Admin;


@Repository
public interface AdminRepository extends JpaRepository<Admin, String>
{
	
	public Admin findByUnameAndPwd(String uname, String pwd);
	
}
