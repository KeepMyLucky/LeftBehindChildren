package com.zc.model;

public class Book {
	
	private String isbn;
	
	private String bookname;
	
	private String author;
	
	private String bookface;
	
	private String overview;

	public Book() {
		super();
	}

	public Book(String isbn, String bookname, String author, String bookface, String overview) {
		super();
		this.isbn = isbn;
		this.bookname = bookname;
		this.author = author;
		this.bookface = bookface;
		this.overview = overview;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", bookname=" + bookname + ", author=" + author + ", bookface=" + bookface
				+ ", overview=" + overview + "]";
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn == null ? null : isbn.trim();
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname == null ? null : bookname.trim();
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author == null ? null : author.trim();
	}

	public String getBookface() {
		return bookface;
	}

	public void setBookface(String bookface) {
		this.bookface = bookface == null ? null : bookface.trim();
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview == null ? null : overview.trim();
	}
}
