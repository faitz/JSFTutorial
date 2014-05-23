package id.fai.tutorial.jsf.dao;

import id.fai.tutorial.jsf.model.User;
import id.fai.tutorial.jsf.model.User.Status;

import java.util.Arrays;
import java.util.List;

public class UserDao {
	
	private static final UserDao INSTANCE = new UserDao();
	
	public static UserDao getInstance(){
		return INSTANCE;
	}
	
	private UserDao() {
	}
	
	private final List<User> users = Arrays.asList(new User("admin", "password", Status.ACTIVE),new User("inactive", "password", Status.INACTIVE));
	
	public List<User> getUsers() {
		return users;
	}
	
	public User validate(String username,String password) throws Exception{
		
		for(User user:users){
			if(user.getUsername().equals(username) && user.getPassword().equals(password)){
				return user;
			}
		}
		
		throw new Exception("Invlalid Combination");
	}

}
