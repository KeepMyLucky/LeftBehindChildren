package com.zc.dao;

import java.util.List;

import com.zc.model.Comment;

public interface CommentDao {
	int insert(Comment comment);

    int insertSelective(Comment comment);

    int deleteByPrimaryKey(String cid);

    int updateByPrimaryKeySelective(Comment comment);

    int updateByPrimaryKey(Comment comment);

    Comment selectByPrimaryKey(String did);
    
    List<Comment> selectAllByPrimaryKey(String did);

    List<Comment> getAll();

	int deleteByDid(String did);


}
