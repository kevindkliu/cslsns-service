package cn.edu.hainmc.cslsns.service;

import java.util.List;

import cn.edu.hainmc.cslsns.model.User;

public interface UserService {

	int create(User user);

	User findById(Long id);

	List<User> findAll();

	User login(User user);

	int update(User user);

	int delete(Long id);

}
