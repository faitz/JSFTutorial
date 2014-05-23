package id.fai.tutorial.jsf.controller;

import id.fai.tutorial.jsf.dao.UserDao;
import id.fai.tutorial.jsf.model.User;
import id.fai.tutorial.jsf.util.SessionHandler;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class LoginController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private UserDao userDao = UserDao.getInstance();
	
	private String username;
	
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
	public String doLogin(){
		FacesContext context = FacesContext.getCurrentInstance();
		boolean error=false;
		if(username == null || username.isEmpty()){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "username is empty!", "username is empty"));
			error = true;
		}
		
		if(password == null || password.isEmpty()){
			
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "password is empty!", "password is empty"));
			
			error = true;
		}
		
		if(error){
			return null;
		}
	
		try {
			User user=userDao.validate(username, password);
			SessionHandler session = context.getApplication().evaluateExpressionGet(context, "#{sessionHandler}", SessionHandler.class);
			session.setCurrentUser(user);
			return "secured";
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
			return null;
		}
	}
	
	
	
	

}
