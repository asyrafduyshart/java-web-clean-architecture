package com.asyraf.example.spring.tools;

/**
 * @author <a href="http://github.com/asyrafduyshart">Asyraf Duyshart</a>
 * @date 5/26/2019
 * @since JDK1.8
 */
public class Assert {

	public static void defaultNotNull(Object obj) {
		final String IS_NULL = " is null";
		org.springframework.util.Assert.notNull(obj, obj.getClass().getSimpleName() + IS_NULL);
	}
}
