package com.zc.model;

import java.util.List;

public class getAllBookMessage extends Message{
	
	private List<Book> books;

	public getAllBookMessage() {
		super();
	}

	public getAllBookMessage(String msg, int code, List<Book> books) {
		super(msg, code);
		this.books = books;
	}

	@Override
	public String toString() {
		return "GetAllBookMessage [books=" + books + "]";
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
}
