package com.zc.dao;

import java.util.List;

import com.zc.model.Dynamic;;

public interface DynamicDao {
	int insert(Dynamic dynamic);

    int insertSelective(Dynamic dynamic);

    int deleteByPrimaryKey(String did);

    int updateByPrimaryKeySelective(Dynamic dynamic);

    int updateByPrimaryKey(Dynamic dynamic);

    Dynamic selectByPrimaryKey(int id);

    List<Dynamic> getAll();

	List<Dynamic> selectByKeyWord(String searchKey);

	List<Dynamic> getmyDynamic(int uid);

}
