package com.klef.jfsd.springboot.models;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "certificate_table")
public class Certificate 
{
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "c_id")
	 private int id;
	 @Column(name="c_name",nullable=false,length = 50)
	 private String certiname;
	 @Column(name = "issued_by", nullable = false, length = 100)
	 private String issuedBy;
	 @Column(name = "issue_date", nullable = false)
	 private String issuedate;
	 @Column(name = "expiry_date",nullable=false)
	 private String expirydate;
	 @Column(name = "status", nullable = false, length = 20)
	 private String status;
	 
	 @ManyToOne 
	 @JoinColumn(name = "u_id", nullable = false)
	 private User user;
	 
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private byte[] imageData;
	
	 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCertiname() {
		return certiname;
	}
	public void setCertiname(String certiname) {
		this.certiname = certiname;
	}
	public byte[] getImageData() {
		return imageData;
	}
	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}
	
	public String getIssuedBy() {
		return issuedBy;
	}
	public void setIssuedBy(String issuedBy) {
		this.issuedBy = issuedBy;
	}
	public String getIssuedate() {
		return issuedate;
	}
	public void setIssuedate(String issuedate) {
		this.issuedate = issuedate;
	}
	public String getExpirydate() {
		return expirydate;
	}
	public void setExpirydate(String expirydate) {
		this.expirydate = expirydate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
