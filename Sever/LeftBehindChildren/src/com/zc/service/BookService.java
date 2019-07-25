package com.zc.service;

import java.util.List;

import com.zc.model.Book;


public interface BookService {
	
	String addBook(Book addInfo);
	
	List<Book> getAll();
	
	String delete(int id);
	
	Book findById(int id);
	
	String update(Book addInfo);

}
