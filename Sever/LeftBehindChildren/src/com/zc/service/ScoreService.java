package com.zc.service;

import java.util.List;

import com.zc.model.Score;

public interface ScoreService {

	String addScore(Score addInfo);
	
	List<Score> getAll();
	
	String delete(int id);
	
	Score findById(int id);
	
	String update(Score addInfo);

	List<Score> getstuScore(String classin, String stuname);
	
}
