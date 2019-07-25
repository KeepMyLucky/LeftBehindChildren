
package com.zc.service;

 

import java.util.List;

import com.zc.model.User;

 

public interface UserService {

	String addInfo(User addInfo);

	List<User> getAll();

	String delete(int id);

	User findById(int id);

	String update(User addInfo);

	User login(User user);
	
	User check(int id);

}