package com.zc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zc.dao.AdminDao;
import com.zc.model.Admin;
import com.zc.model.Book;
import com.zc.model.Dynamic;
import com.zc.model.Score;
import com.zc.model.User;
import com.zc.model.overviewNumber;
import com.zc.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminDao adminDao;
	public AdminDao getAdminDao() {
		return adminDao;
	}
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
	@Override
	public Admin login(Admin admin) {
		return adminDao.selectByIdAndPassword(admin);
	}
	@Override
	public List<User> getUserListPage(Integer uid, String username, Integer offset, Integer pageSize) {
		return adminDao.getUserListPage(uid, username, offset, pageSize);
	}
	@Override
	public int getUserListNumber(Integer uid, String username) {
		return adminDao.getUserListNumber(uid, username);
	}
	@Override
	public int delete(Integer uid) {
		return adminDao.deleteUserByUid(uid);
	}
	@Override
	public int updateUser(User user) {
		return adminDao.updateUser(user);
	}
	@Override
	public int getDynamicListNumber(Integer did, Integer uid) {
		return adminDao.getDynamicListNumber(did, uid);
	}
	@Override
	public List<Dynamic> getDynamicListPage(Integer uid, Integer did, Integer offset, Integer pageSize) {
		return adminDao.getDynamicListPage(uid, did, offset, pageSize);
	}
	@Override
	public int deleteDynamic(String did) {
		return adminDao.deleteDynamicByDid(did);
	}
	@Override
	public int updateDynamic(Dynamic dynamic) {
		return adminDao.updateDynamic(dynamic);
	}
	@Override
	public List<Book> getBookListPage(Integer isbn, String keyword, Integer offset, Integer pageSize) {
		return adminDao.getBookListPage(isbn, keyword, offset, pageSize);
	}
	@Override
	public int getBookListNumber(Integer isbn, String keyword) {
		return adminDao.getBookListNumber(isbn, keyword);
	}
	@Override
	public int deleteBook(String isbn) {
		return adminDao.deleteBookByIsbn(isbn);
	}
	@Override
	public int updateBook(Book book) {
		return adminDao.updateBook(book);
	}
	
	@Override
	public overviewNumber getOverViewNumber() {
		return adminDao.getOverViewNumber();
	}
	@Override
	public List<Score> getScoreListPage(String examtype, String classin, String stuname, Integer offset,
			Integer pageSize) {
		return adminDao.getScoreListPage(examtype, classin, stuname, offset, pageSize);
	}
	@Override
	public int getScoreListNumber(String examtype, String classin, String stuname) {
		return adminDao.getScoreListNumber(examtype, classin, stuname);
	}
	@Override
	public List<String> getexamTypeList() {
		return adminDao.getexamTypeList();
	}
	@Override
	public List<String> getclassInList() {
		return adminDao.getclassInList();
	}
	@Override
	public int updateScore(Score score) {
		return adminDao.updateScore(score);
	}
	@Override
	public int deleteScore(int id) {
		return adminDao.deleteScoreById(id);
	}
	
}
