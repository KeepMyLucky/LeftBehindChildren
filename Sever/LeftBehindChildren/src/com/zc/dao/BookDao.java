package com.zc.dao;

import java.util.List;

import com.zc.model.Book;

public interface BookDao {
	
	int insert(Book book);

    int insertSelective(Book book);

    int deleteByPrimaryKey(int id);

    int updateByPrimaryKeySelective(Book book);

    int updateByPrimaryKey(Book book);

    Book selectByPrimaryKey(int id);

    List<Book> getAll();


}
