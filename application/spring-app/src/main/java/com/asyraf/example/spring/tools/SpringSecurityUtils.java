package com.asyraf.example.spring.tools;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

import javax.servlet.http.HttpServletRequest;

/**
 * @author <a href="http://github.com/asyrafduyshart">Asyraf Duyshart</a>
 * @date 5/26/2019
 * @since JDK1.8
 */
public class SpringSecurityUtils {

	/**
	 * Get current user.
	 *
	 * @param <T> user details
	 * @return user details
	 */
	@SuppressWarnings("unchecked")
	public static <T extends UserDetails> T getCurrentUser() {
		Authentication authentication = getAuthentication();
		if (authentication == null) {
			return null;
		}
		Object principal = authentication.getPrincipal();
		if (!(principal instanceof UserDetails)) {
			return null;
		}
		return (T) principal;

	}

	/**
	 * Get current username.
	 *
	 * @return current username
	 */
	public static String getCurrentUsername() {
		Authentication authentication = getAuthentication();
		if ((authentication == null) || (authentication.getPrincipal() == null)) {
			return "";
		}
		return authentication.getName();
	}

	/**
	 * Save user details to security context.
	 *
	 * @param userDetails user details
	 * @param request     request
	 */
	public static void saveUserDetailsToContext(UserDetails userDetails, HttpServletRequest request) {
		PreAuthenticatedAuthenticationToken authentication = new PreAuthenticatedAuthenticationToken(
			userDetails,
			userDetails.getPassword(), userDetails.getAuthorities());

		if (request != null) {
			authentication.setDetails(new WebAuthenticationDetails(request));
		}

		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	/**
	 * Get Authentication
	 *
	 * @return authentication
	 */
	private static Authentication getAuthentication() {
		SecurityContext context = SecurityContextHolder.getContext();
		if (context == null) {
			return null;
		}
		return context.getAuthentication();
	}
}
