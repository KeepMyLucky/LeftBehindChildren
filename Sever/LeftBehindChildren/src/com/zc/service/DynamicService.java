package com.zc.service;

import java.util.List;

import com.zc.model.Dynamic;

public interface DynamicService {
	
	String addDynamic(Dynamic addInfo);
	
	List<Dynamic> getAll();
	
	String delete(String did);
	
	Dynamic findById(int id);
	
	List<Dynamic> findById(String searchKey);
	
	String update(Dynamic addInfo);

	List<Dynamic> getmyDynamic(int uid);
}
