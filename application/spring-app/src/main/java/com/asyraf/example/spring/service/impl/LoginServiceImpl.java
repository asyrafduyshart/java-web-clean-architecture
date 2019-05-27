package com.asyraf.example.spring.service.impl;

import com.asyraf.example.controller.UserController;
import com.asyraf.example.db.psql.domain.UserDomain;
import com.asyraf.example.db.psql.po.UserPO;
import com.asyraf.example.spring.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


/**
 * @author <a href="http://github.com/asyrafduyshart">Asyraf Duyshart</a>
 * @date 5/26/2019
 * @since JDK1.8
 */
@Service
public class LoginServiceImpl implements LoginService {

	private final UserController controller;
	private final UserDomain userDomain;

	@Override public ResponseEntity login() throws Exception {

		UserPO userPO = new UserPO();
		userPO.setAccount("Asyraf");
		userPO.setEmail("me@asyraf.id");
		userPO.setFirstName("Asyraf");
		userPO.setLastName("Duyshart");

		return new ResponseEntity<>(userDomain.createByPO(userPO), HttpStatus.OK);
	}

	@Autowired
	public LoginServiceImpl(final UserController controller, UserDomain userDomain) {
		this.controller = controller;
		this.userDomain = userDomain;
	}
}
