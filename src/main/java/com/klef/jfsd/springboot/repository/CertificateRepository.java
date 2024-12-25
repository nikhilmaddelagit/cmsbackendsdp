package com.klef.jfsd.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klef.jfsd.springboot.models.Certificate;
import com.klef.jfsd.springboot.models.User;

public interface CertificateRepository extends JpaRepository<Certificate, Integer> 
{
       List<Certificate> findByUser(User user);
       
}
