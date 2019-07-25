package com.zc.dao;

import java.util.List;

import com.zc.model.Reply;

public interface ReplyDao {
	
	int insert(Reply reply);

    int insertSelective(Reply reply);

    int deleteByPrimaryKey(String rid);
    
    int deleteByCid(String cid);

    int updateByPrimaryKeySelective(Reply reply);

    int updateByPrimaryKey(Reply reply);

    Reply selectByPrimaryKey(String rid);
    
    List<Reply> selectAllByPrimaryKey(String rid);

    List<Reply> getAll();

	int deleteByDid(String did);

}
