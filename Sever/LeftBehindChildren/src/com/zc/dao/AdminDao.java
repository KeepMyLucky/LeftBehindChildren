package com.zc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zc.model.Admin;
import com.zc.model.Book;
import com.zc.model.Dynamic;
import com.zc.model.Score;
import com.zc.model.User;
import com.zc.model.overviewNumber;

public interface AdminDao {
	Admin selectByIdAndPassword(Admin admin);

	List<User> getUserListPage(@Param("uid") Integer uid, @Param("username") String username, @Param("offset") Integer offset,  @Param("pageSize") Integer pageSize);
	int getUserListNumber(@Param("uid") Integer uid, @Param("username") String username);
	int deleteUserByUid(Integer uid);
	int updateUser(User user);

	List<Dynamic> getDynamicListPage(@Param("uid") Integer uid, @Param("did") Integer did, @Param("offset") Integer offset,  @Param("pageSize") Integer pageSize);
	int getDynamicListNumber(@Param("did") Integer did, @Param("uid") Integer uid);
	int deleteDynamicByDid(String did);
	int updateDynamic(Dynamic dynamic);

	List<Book> getBookListPage(@Param("isbn") Integer isbn, @Param("keyword") String keyword, @Param("offset") Integer offset, @Param("pageSize") Integer pageSize);
	int getBookListNumber(@Param("isbn") Integer isbn, @Param("keyword") String keyword);
	int deleteBookByIsbn(String isbn);
	int updateBook(Book book);

	overviewNumber getOverViewNumber();

	List<Score> getScoreListPage(@Param("examtype") String examtype, @Param("classin") String classin, @Param("stuname") String stuname,  @Param("offset") Integer offset, @Param("pageSize") Integer pageSize);
	int getScoreListNumber(@Param("examtype") String examtype, @Param("classin") String classin, @Param("stuname") String stuname);
	List<String> getexamTypeList();
	List<String> getclassInList();
	int updateScore(Score score);
	int deleteScoreById(Integer id);
	
}
