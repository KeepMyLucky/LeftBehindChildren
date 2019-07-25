package com.zc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zc.dao.ReplyDao;
import com.zc.model.Reply;
import com.zc.service.ReplyService;

@Service
public class ReplyServiceImpl implements ReplyService{
	
	
	@Autowired
	private ReplyDao replyDao;
	
	public ReplyDao getCommentDao() {
		return replyDao;
	}

	public void setCommentDao(ReplyDao replyDao) {
		this.replyDao = replyDao;
	}
	
	@Override
	public String addComment(Reply addInfo) {
		if(replyDao.insertSelective(addInfo)==1) {
			return "添加成功";
		}
		return "添加失败";
	}

	@Override
	public List<Reply> getAll() {
		return replyDao.getAll();
		}

	@Override
	public String delete(String rid) {
		if(replyDao.deleteByPrimaryKey(rid)==1) {
			return "删除成功";
		}
		return "删除失败";
	}

	@Override
	public String deleteByCid(String cid) {
		if(replyDao.deleteByCid(cid)==1) {
			return "删除成功";
		}
		return "删除失败";
	}

	@Override
	public Reply findById(String cid) {
		return replyDao.selectByPrimaryKey(cid);
		}

	@Override
	public List<Reply> findByCid(String cid) {
		return replyDao.selectAllByPrimaryKey(cid);
		}

	@Override
	public String update(Reply addInfo) {
		if(replyDao.updateByPrimaryKeySelective(addInfo)==1) {
			return "更新成功";
		}
		return "更新失败";
	}

	@Override
	public String deleteByDid(String did) {
		if(replyDao.deleteByDid(did)==1) {
			System.out.println("chenggong");
			return "删除成功";
		}
		return "删除失败";
	}
	
}
