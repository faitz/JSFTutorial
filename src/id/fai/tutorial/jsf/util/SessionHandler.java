package id.fai.tutorial.jsf.util;

import id.fai.tutorial.jsf.model.User;
import id.fai.tutorial.jsf.model.User.Status;

import java.io.Serializable;

public class SessionHandler implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String username;
	private boolean active;
	
	public String getCurrentUser(){
		return username;
	}
	
	public boolean isActive() {
		return active;
	}
	
	public void setCurrentUser(User user){
		this.username = user.getUsername();
		this.active = Status.ACTIVE == user.getStatus();
	}

}
