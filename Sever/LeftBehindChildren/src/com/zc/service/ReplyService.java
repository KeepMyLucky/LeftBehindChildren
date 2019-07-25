package com.zc.service;

import java.util.List;

import com.zc.model.Reply;

public interface ReplyService {
	
	String addComment(Reply addInfo);
	
	List<Reply> getAll();
	
	String delete(String rid);
	
	String deleteByCid(String cid);
	
	Reply findById(String cid);
	
	List<Reply>  findByCid(String cid);
	
	String update(Reply addInfo);

	String deleteByDid(String did);


}
