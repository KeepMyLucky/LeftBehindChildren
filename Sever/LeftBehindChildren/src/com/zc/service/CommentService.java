package com.zc.service;

import java.util.List;

import com.zc.model.Comment;


public interface CommentService {
	
	String addComment(Comment addInfo);
	
	List<Comment> getAll();
	
	String delete(String cid);
	
	Comment findById(String did);
	
	List<Comment>  findByDid(String did);
	
	String update(Comment addInfo);

	String deleteByDid(String did);

}
