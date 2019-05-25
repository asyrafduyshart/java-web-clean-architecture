package com.asyraf.example.controller;

import com.asyraf.example.controller.model.UserWeb;
import com.asyraf.example.usecase.CreateUser;
import com.asyraf.example.usecase.FindUser;
import com.asyraf.example.usecase.LoginUser;
import java.util.List;
import java.util.stream.Collectors;

public class UserController {

	private final CreateUser createUser;
	private final FindUser findUser;
	private final LoginUser loginUser;

	public UserController(final CreateUser createUser, final FindUser findUser, final LoginUser loginUser) {
		this.createUser = createUser;
		this.findUser = findUser;
		this.loginUser = loginUser;
	}

	public UserWeb createUser(final UserWeb userWeb) {
		var user = userWeb.toUser();
		return UserWeb.toUserWeb(createUser.create(user));
	}

	public UserWeb login(final String email, final String password) {
		return UserWeb.toUserWeb(loginUser.login(email, password));
	}

	public UserWeb getUser(final String userId) {
		return UserWeb.toUserWeb(findUser.findById(userId).orElseThrow(() -> new RuntimeException("user not found")));
	}

	public List<UserWeb> allUsers() {
		return findUser.findAllUsers()
			.stream()
			.map(UserWeb::toUserWeb)
			.collect(Collectors.toList());
	}
}
