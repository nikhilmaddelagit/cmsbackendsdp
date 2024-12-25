package com.klef.jfsd.springboot.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.klef.jfsd.springboot.models.Certificate;

public interface CertiService
{
	public String addCertificate(Certificate certificate,MultipartFile file,int uid) throws IOException;
	public String updateCertificate(Certificate certificate);
	public void deleteCertificate(int id);
	public List<Certificate> ViewAllCertificates(int uid);
	public Certificate ViewCertiByID(int certiid);
	
}