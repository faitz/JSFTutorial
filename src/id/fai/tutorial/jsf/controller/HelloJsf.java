package id.fai.tutorial.jsf.controller;

import java.io.Serializable;

public class HelloJsf implements Serializable{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	
	private String name;


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	public String getMessage(){
		if(name==null){
			return "";
		}else{
			return "Hello "+this.name;
		}
		
	}
	
}

