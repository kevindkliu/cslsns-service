package cn.edu.hainmc.cslsns.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import cn.edu.hainmc.cslsns.common.bean.ResponseResult;
import cn.edu.hainmc.cslsns.common.enums.ResponseErrorEnum;
import cn.edu.hainmc.cslsns.common.util.RestResultGenerator;
import cn.edu.hainmc.cslsns.model.User;
import cn.edu.hainmc.cslsns.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1.0")
public class UserController {

	@Autowired
	private UserService userService;

	// 新建
	@ApiOperation(value = "新建一个用户", notes = "根据User对象创建用户")
	@ApiImplicitParam(name = "user", value = "用户实体user", required = true, dataType = "User")
	@RequestMapping(value = "/users", method = RequestMethod.POST, consumes = "application/json; charset=utf-8")
	ResponseResult<User> create(@Validated @RequestBody User user) {

		User user2 = null;
		try {
			int iResult = userService.create(user);
			if (iResult > 0) {
				user2 = user;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return RestResultGenerator.genResponseResult(user2, ResponseErrorEnum.FAILURE);
		}
		return RestResultGenerator.genResponseResult(user2, ResponseErrorEnum.SUCCESS);
	}

	// 通过用户ID查找
	@ApiOperation(value = "通过用户ID查询用户", notes = "通过用户ID查询用户")
	@ApiImplicitParam(name = "id", value = "用户实体user", required = true, dataType = "User")
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	ResponseResult<User> findById(@PathVariable("id") Long id) {

		User user = userService.findById(id);
		if (user != null) {
			return RestResultGenerator.genResponseResult(user, ResponseErrorEnum.SUCCESS);
		} else {
			return RestResultGenerator.genResponseResult(user, ResponseErrorEnum.RESULE_DATA_NONE);
		}
	}

	// 获取所有用户
	@RequestMapping(value = "/users/all", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	ResponseResult<List<User>> findAll() {

		List<User> userList = userService.findAll();
		if (userList != null && !userList.isEmpty()) {
			return RestResultGenerator.genResponseResult(userList, ResponseErrorEnum.SUCCESS);
		} else {
			return RestResultGenerator.genResponseResult(userList, ResponseErrorEnum.RESULE_DATA_NONE);
		}
	}

	// 登录验证
	@RequestMapping(value = "/users/login", method = RequestMethod.GET, consumes = "application/json; charset=utf-8")
	ResponseResult<User> login(@Validated @RequestBody User user) {

		User user1 = userService.login(user);
		return RestResultGenerator.genResponseResult(user1, ResponseErrorEnum.SUCCESS);
	}

	// 更新
	@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT, consumes = "application/json; charset=utf-8")
	ResponseResult<User> update(@PathVariable("id") Long id, @Validated @RequestBody User user) {

		User user1 = userService.findById(id);
		User user2 = null;

		if (user1 != null) {
			user.setId(id);
			int iResult = userService.update(user);
			if (iResult > 0) {
				user2 = user;
			}
		}
		return RestResultGenerator.genResponseResult(user2, ResponseErrorEnum.SUCCESS);
	}

	// 删除
	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE, consumes = "application/json; charset=utf-8")
	ResponseResult<User> delete(@PathVariable("id") Long id) {

		User user1 = userService.findById(id);
		if (user1 != null) {
			int iResult = userService.delete(id);
			if (iResult > 0) {
				return RestResultGenerator.genResponseResult(user1, ResponseErrorEnum.SUCCESS);
			} else {
				return RestResultGenerator.genResponseResult(user1, ResponseErrorEnum.RESULE_DATA_NONE);
			}
		} else {
			return RestResultGenerator.genResponseResult(user1, ResponseErrorEnum.RESULE_DATA_NONE);
		}
	}
}
