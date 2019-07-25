package com.zc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zc.dao.ScoreDao;
import com.zc.model.Score;
import com.zc.service.ScoreService;

@Service
public class ScoreServiceImpl implements ScoreService{
	@Autowired
	private ScoreDao scoreDao;
	
	public ScoreDao getScoreDao() {
		return scoreDao;
	}

	public void setScoreDao(ScoreDao scoreDao) {
		this.scoreDao = scoreDao;
	}

	@Override
	public String addScore(Score addInfo) {
		if(scoreDao.insertSelective(addInfo)==1) {
			return "添加成功";
		}
		return "添加失败";
	}

	@Override
	public List<Score> getAll() {
		return scoreDao.getAll();
	}

	@Override
	public String delete(int id) {
		if(scoreDao.deleteByPrimaryKey(id)==1) {
			return "删除成功";
		}
		return "删除失败";
	}

	@Override
	public Score findById(int id) {
		return scoreDao.selectByPrimaryKey(id);
	}

	@Override
	public String update(Score addInfo) {
		if(scoreDao.updateByPrimaryKeySelective(addInfo)==1) {
			return "更新成功";
		}
		return "更新失败";
	}

	@Override
	public List<Score> getstuScore(String classin, String stuname) {
		return scoreDao.getstuScore(classin, stuname);
	}

}
