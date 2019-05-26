package com.asyraf.example.spring.interceptor;

import com.asyraf.example.spring.component.LogHelper;
import com.asyraf.example.spring.constant.ResourcePath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author <a href="http://github.com/asyrafduyshart">Asyraf Duyshart</a>
 * @date 5/26/2019
 * @since JDK1.8
 */
@Component
public class LogInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
						   ModelAndView modelAndView) {}

	@Override public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
										  Object handler, Exception ex) {
		if (!(HttpMethod.GET.matches(request.getMethod())
			|| HttpMethod.DELETE.matches(request.getMethod()))) {
			String path = request.getRequestURI();
			HttpStatus status = HttpStatus.resolve(response.getStatus());
			if (!path.contains(ResourcePath.OPEN) && status != null && !status.isError()) {
				logHelper.log(HttpMethod.resolve(request.getMethod()), path);
			}
		}
	}

	private final LogHelper logHelper;

	@Autowired public LogInterceptor(LogHelper logHelper) {
		this.logHelper = logHelper;
	}
}
