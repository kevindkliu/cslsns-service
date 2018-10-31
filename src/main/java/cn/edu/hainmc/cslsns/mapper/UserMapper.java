package cn.edu.hainmc.cslsns.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.edu.hainmc.cslsns.model.User;

@Mapper
public interface UserMapper {
	// CRUD:
	// c create
	// r retrieve select
	// u update
	// d delete
	int create(@Param(value="user") User user);

	User findById(@Param(value="id") Long id);

	List<User> findAll();
	
	User login(@Param(value="user") User user);

	int update(@Param(value="user") User user);

	int delete(@Param(value="id") Long id);
}
