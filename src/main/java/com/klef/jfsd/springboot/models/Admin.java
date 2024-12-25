package com.klef.jfsd.springboot.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="admin_table")
public class Admin 
{
	@Id
	@Column(name = "admin_username", length = 50 , nullable = false)
	private String uname;
	
	@Column(name = "admin_password",length = 50, nullable=false)
	private String pwd;

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "Admin [uname=" + uname + ", pwd=" + pwd + "]";
	}

	
	

}
