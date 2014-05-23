package id.fai.tutorial.jsf.model;

import java.io.Serializable;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public enum Status {ACTIVE,INACTIVE}
	
	private String username;
	private String password;
	private Status status;
	
	public User(String username,String password,Status status) {
		this.username = username;
		this.password = password;
		this.status = status;
	}
	public User() {
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	

}
