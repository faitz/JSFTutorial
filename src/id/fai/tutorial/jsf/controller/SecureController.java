package id.fai.tutorial.jsf.controller;

import id.fai.tutorial.jsf.util.SessionHandler;

import java.io.Serializable;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class SecureController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String getMessage(){
		SessionHandler session = FacesContext.getCurrentInstance().getApplication().evaluateExpressionGet(FacesContext.getCurrentInstance(), "#{sessionHandler}", SessionHandler.class);
		if(!session.isActive()){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "your account is inactive", "your account is inactive"));
		}
		return "Hello "+session.getCurrentUser()+" you are on secured page";
		
	}
	
	public String logout(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login.xhtml?faces-redirect=true";
	}
	
	public Date getAccessTime(){
		return new Date();
	}

}
