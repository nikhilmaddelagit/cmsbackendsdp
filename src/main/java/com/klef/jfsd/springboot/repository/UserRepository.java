package com.klef.jfsd.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.klef.jfsd.springboot.models.Certificate;
import com.klef.jfsd.springboot.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{
    User findByEmailAndPassword(String email, String password);
    
    
    @Query("SELECT c FROM Certificate c")
    List<Certificate> ViewAllCertificates();
    
    @Query("SELECT c FROM Certificate c WHERE c.id = :id")
    Certificate ViewCertiByID(int id);
    
    
    public User  findByEmail(String email);
}
