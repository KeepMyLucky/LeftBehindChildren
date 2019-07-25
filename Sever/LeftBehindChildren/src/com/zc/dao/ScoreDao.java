package com.zc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zc.model.Score;


public interface ScoreDao {
	
	int insert(Score score);

    int insertSelective(Score score);

    int deleteByPrimaryKey(int id);

    int updateByPrimaryKeySelective(Score score);

    int updateByPrimaryKey(Score score);

    Score selectByPrimaryKey(int id);

    List<Score> getAll();

	List<Score> getstuScore(@Param("classin") String classin, @Param("stuname") String stuname);
    
}
