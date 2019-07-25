
package com.zc.dao;

 

import java.util.List;

import com.zc.model.User;

 

public interface UserDao {  

    int insert(User user);

    int insertSelective(User user);

    int deleteByPrimaryKey(int id);

    int updateByPrimaryKeySelective(User user);

    int updateByPrimaryKey(User user);

    User selectByPrimaryKey(int id);

    List<User> getAll();

	User selectByIdAndPassword(User user);

	User selectById(int id);

}
