package com.asyraf.example.spring.service;

import com.asyraf.example.spring.param.LoginParam;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

/**
 * @author <a href="http://github.com/asyrafduyshart">Asyraf Duyshart</a>
 * @date 5/26/2019
 * @since JDK1.8
 */
public interface LoginService {

	ResponseEntity login() throws Exception;

}

