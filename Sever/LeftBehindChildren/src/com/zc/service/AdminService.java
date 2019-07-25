package com.zc.service;

import java.util.List;

import com.zc.model.Admin;
import com.zc.model.Book;
import com.zc.model.Dynamic;
import com.zc.model.Score;
import com.zc.model.User;
import com.zc.model.overviewNumber;

public interface AdminService {
	Admin login(Admin admin);
	List<User> getUserListPage(Integer uid, String username, Integer offset, Integer pageSize);
	int getUserListNumber(Integer uid, String username);
	int delete(Integer uid);
	int updateUser(User user);
	List<Dynamic> getDynamicListPage(Integer uid, Integer did, Integer offset, Integer pageSize);
	int getDynamicListNumber(Integer did, Integer uid);
	int deleteDynamic(String did);
	int updateDynamic(Dynamic dynamic);
	List<Book> getBookListPage(Integer isbn, String keyword, Integer offset, Integer pageSize);
	int getBookListNumber(Integer isbn, String keyword);
	int deleteBook(String isbn);
	int updateBook(Book book);
	
	overviewNumber getOverViewNumber();
	
	List<Score> getScoreListPage(String examtype, String classin, String stuname, Integer offset, Integer pageSize);
	int getScoreListNumber(String examtype, String classin, String stuname);
	List<String> getexamTypeList();
	List<String> getclassInList();
	int updateScore(Score score);
	int deleteScore(int id);
}
