package com.zc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zc.dao.CommentDao;
import com.zc.model.Comment;
import com.zc.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	private CommentDao commentDao;
	
	public CommentDao getCommentDao() {
		return commentDao;
	}

	public void setCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}

	@Override
	public String addComment(Comment addInfo) {
		if(commentDao.insertSelective(addInfo)==1) {
			return "添加成功";
		}
		return "添加失败";
	}

	@Override
	public List<Comment> getAll() {
		return commentDao.getAll();
	}

	@Override
	public String delete(String cid) {
		if(commentDao.deleteByPrimaryKey(cid)==1) {
			return "删除成功";
		}
		return "删除失败";
	}

	@Override
	public Comment findById(String did) {
		return commentDao.selectByPrimaryKey(did);
		}

	@Override
	public String update(Comment addInfo) {
		if(commentDao.updateByPrimaryKeySelective(addInfo)==1) {
			return "更新成功";
		}
		return "更新失败";
	}

	@Override
	public List<Comment> findByDid(String did) {
		return commentDao.selectAllByPrimaryKey(did);
	}

	@Override
	public String deleteByDid(String did) {
		if(commentDao.deleteByDid(did)==1) {
			return "删除成功";
		}
		return "删除失败";
	}
	
}
