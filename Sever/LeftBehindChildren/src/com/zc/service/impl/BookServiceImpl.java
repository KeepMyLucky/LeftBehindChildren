package com.zc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zc.dao.BookDao;
import com.zc.model.Book;
import com.zc.service.BookService;

@Service
public class BookServiceImpl implements BookService{
	@Autowired
	private BookDao bookDao;

	public BookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public String addBook(Book addInfo) {
		if(bookDao.insertSelective(addInfo)==1) {
			return "添加成功";
		}
		return "添加失败";
	}

	@Override
	public List<Book> getAll() {
		return bookDao.getAll();
	}

	@Override
	public String delete(int id) {
		if(bookDao.deleteByPrimaryKey(id)==1) {
			return "删除成功";
		}
		return "删除失败";
	}

	@Override
	public Book findById(int id) {
		return bookDao.selectByPrimaryKey(id);
	}

	@Override
	public String update(Book addInfo) {
		if(bookDao.updateByPrimaryKeySelective(addInfo)==1) {
			return "更新成功";
		}
		return "更新失败";
	}
	
}
