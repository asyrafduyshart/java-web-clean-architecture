package com.asyraf.example.spring.controller.open;

import com.asyraf.example.controller.UserController;
import com.asyraf.example.spring.component.ResultHelper;
import com.asyraf.example.spring.constant.ResourcePath;
import com.asyraf.example.spring.enums.ErrorType;
import com.asyraf.example.spring.param.LoginParam;
import com.asyraf.example.spring.service.LoginService;
import com.asyraf.example.spring.tools.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author <a href="http://github.com/asyrafduyshart">Asyraf Duyshart</a>
 * @date 5/26/2019
 * @since JDK1.11
 */
@RestController
@RequestMapping(ResourcePath.API + ResourcePath.V1 + ResourcePath.OPEN + ResourcePath.LOGIN)
public class LoginController {



	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity login() {
		try {
			logger.info("=============IAMHERE");
			return loginService.login();
		}
		catch (Exception e) {
			// Return unknown error and log the exception.
			return resultHelper.errorResp(logger, e, ErrorType.UNKNOWN, e.getMessage(),
				HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	private final LoginService loginService;
	private final ResultHelper resultHelper;

	@Autowired
	public LoginController(LoginService loginService, ResultHelper resultHelper) {
		Assert.defaultNotNull(loginService);
		Assert.defaultNotNull(resultHelper);
		this.loginService = loginService;
		this.resultHelper = resultHelper;
	}
}
