package com.klef.jfsd.springboot.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.klef.jfsd.springboot.models.Certificate;
import com.klef.jfsd.springboot.service.CertiService;


@RestController
@RequestMapping("/certificate")
@CrossOrigin(origins = "https://certification-management-sy-git-b29b9f-nikhil-maddelas-projects.vercel.app/") // Allow CORS for specific frontend origin

public class CertificateController 
{
    @Autowired
    private CertiService service;

    
    @PostMapping("/addcertificate/{uid}")
    public ResponseEntity<String> addCertificate(@RequestPart("data") Certificate certificate,@RequestPart("file") MultipartFile file,@PathVariable("uid")int uid) throws IOException
    {
    	String msg = service.addCertificate(certificate,file,uid);
    	return ResponseEntity.ok(msg);
    }

    @GetMapping("/viewall/{uid}")
    public ResponseEntity<List<Certificate>> viewAllCertificates(@PathVariable("uid")int uid) {
        List<Certificate> certificates = service.ViewAllCertificates(uid);
        return ResponseEntity.ok(certificates);
    }
    
    @GetMapping("/getcertificate/{id}")
    public ResponseEntity<byte[]> getCertificateById(@PathVariable int id) {
        Certificate cert = service.ViewCertiByID(id);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(cert.getImageData());
    }    
    
    @DeleteMapping("/deletecerti/{id}")
    public ResponseEntity<String> deleteCertificate(@PathVariable("id") int id) {
        try {
            service.deleteCertificate(id); 
            return ResponseEntity.ok("Certificate deleted successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to delete certificate.");
        }
    }

    @PutMapping("/update")
    public String UpdateCertificate(@RequestBody Certificate certificate)
    {
    	return service.updateCertificate(certificate);
    }
    
    
    
}
