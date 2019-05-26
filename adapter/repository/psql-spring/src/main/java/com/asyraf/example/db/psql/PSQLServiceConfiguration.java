package com.asyraf.example.db.psql;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author <a href="http://github.com/asyrafduyshart">Asyraf Duyshart</a>
 * @date 5/26/2019
 * @since JDK1.8
 */
@ComponentScan(value = {"com.asyraf.example"})
@Configuration
public class PSQLServiceConfiguration {
	public static String test() {
		return "Yomama";
	}
}
