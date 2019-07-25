package com.zc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zc.dao.DynamicDao;
import com.zc.model.Dynamic;
import com.zc.service.DynamicService;

@Service
public class DynamicServiceImpl implements DynamicService{
	@Autowired
	private DynamicDao dynamicDao;

	public DynamicDao getDynamicDao() {
		return dynamicDao;
	}

	public void setDynamicDao(DynamicDao dynamicDao) {
		this.dynamicDao = dynamicDao;
	}

	@Override
	public String addDynamic(Dynamic addInfo) {
		if(dynamicDao.insertSelective(addInfo)==1) {
			return "添加成功";
		}
		return "添加失败";
	}

	@Override
	public List<Dynamic> getAll() {
		return dynamicDao.getAll();
	}

	@Override
	public String delete(String did) {
		if(dynamicDao.deleteByPrimaryKey(did)==1) {
			return "删除成功";
		}
		return "删除失败";
	}

	@Override
	public Dynamic findById(int id) {
		return dynamicDao.selectByPrimaryKey(id);
	}

	@Override
	public String update(Dynamic addInfo) {
		if(dynamicDao.updateByPrimaryKeySelective(addInfo)==1) {
			return "更新成功";
		}
		return "更新失败";
	}

	@Override
	public List<Dynamic> findById(String searchKey) {
		return dynamicDao.selectByKeyWord(searchKey);
	}

	@Override
	public List<Dynamic> getmyDynamic(int uid) {
		return dynamicDao.getmyDynamic(uid);
	}
}
