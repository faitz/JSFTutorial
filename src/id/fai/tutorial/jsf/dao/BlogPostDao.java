package id.fai.tutorial.jsf.dao;

import id.fai.tutorial.jsf.model.BlogPost;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BlogPostDao implements Serializable{
	
	private static final List<BlogPost> posts = new ArrayList<BlogPost>();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public List<BlogPost> getPosts(){
		return posts;
	}
	
	public void addPost(BlogPost post){
		posts.add(post);
	}
	
	public void removePost(BlogPost post){
		posts.remove(post);
	}

}
