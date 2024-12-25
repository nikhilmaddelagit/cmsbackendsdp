package com.klef.jfsd.springboot.service;


import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.klef.jfsd.springboot.models.Certificate;
import com.klef.jfsd.springboot.models.User;
import com.klef.jfsd.springboot.repository.CertificateRepository;
import com.klef.jfsd.springboot.repository.UserRepository;

@Service
public class CertiServiceImpl implements CertiService
{
	
	@Autowired
	private CertificateRepository certificateRepository;
	@Autowired
	private UserRepository userrepo;
	
	@Override
	public String addCertificate(Certificate certificate,MultipartFile file,int uid) throws IOException
	{
		certificate.setCertiname(certificate.getCertiname());
		User user=userrepo.findById(uid).orElseThrow();
		certificate.setUser(user);
		certificate.setImageData(file.getBytes());
		certificateRepository.save(certificate);
		return "Successfully Uploaded";
	}

	@Override
	public List<Certificate> ViewAllCertificates(int uid) 
	{
		User user=userrepo.findById(uid).orElseThrow();
		return certificateRepository.findByUser(user);
	}

	@Override
	public Certificate ViewCertiByID(int certiid) 
	{
		return certificateRepository.findById(certiid).get();
	}

	@Override
	public String updateCertificate(Certificate certificate) 
	{
		Optional<Certificate> obj = certificateRepository.findById(certificate.getId());
		String msg = null;
		if(obj.isPresent())
		{
			Certificate c = obj.get();
			c.setCertiname(certificate.getCertiname());
			c.setExpirydate(certificate.getExpirydate());
			c.setIssuedate(certificate.getIssuedate());
			c.setIssuedBy(certificate.getIssuedBy());
			c.setStatus(certificate.getStatus());
			
			
			certificateRepository.save(c);
			
			msg = "Certificate Updated Successfully!!";
		}
		else
		{
			msg = "Certificates Not Updated!!";
		}
		return msg;
	}

	@Override
	public void deleteCertificate(int id) {
        certificateRepository.deleteById(id);
    }
}