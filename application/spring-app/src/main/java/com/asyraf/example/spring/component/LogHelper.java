package com.asyraf.example.spring.component;

import com.asyraf.example.spring.tools.RemoteAddressUtils;
import com.asyraf.example.spring.tools.SpringSecurityUtils;
import com.asyraf.example.spring.vo.LogVO;
import org.apache.commons.lang3.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author <a href="http://github.com/asyrafduyshart">Asyraf Duyshart</a>
 * @date 5/26/2019
 * @since JDK1.8
 */
@Component
public class LogHelper {

	public void log(HttpServletRequest request) {
		String ip = RemoteAddressUtils.getRealIp(request);
		LogVO log = LogVO.builder()
			.usr(SpringSecurityUtils.getCurrentUsername())
			.ip(StringUtils.isBlank(ip) ? "0.0.0.0.0.0.0.0:1" : ip)
			.path(request.getRequestURI().substring(request.getContextPath().length()))
			.method(HttpMethod.GET)
			.build();

	}

	public void log(HttpMethod method, String usr, String ip, String clientId,
					String path) {
		LogVO log = LogVO.builder()
			.usr(usr)
			.ip(StringUtils.isBlank(ip) ? "0.0.0.0.0.0.0.0:1" : ip)
			.clientId(clientId)
			.path(path)
			.method(method)
			.build();

	}

	public void log(HttpMethod method) {

		LogVO log = LogVO.builder()
			.usr(SpringSecurityUtils.getCurrentUsername())
			.ip("0.0.0.0.0.0.0.0:1")
			.method(method)
			.build();

	}

	public void log(HttpMethod method, String path) {
		LogVO log = LogVO.builder()
			.usr(SpringSecurityUtils.getCurrentUsername())
			.ip("0.0.0.0.0.0.0.0:1")
			.path(path)
			.method(method)
			.build();

	}

}
