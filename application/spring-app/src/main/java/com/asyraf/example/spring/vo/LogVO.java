package com.asyraf.example.spring.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpMethod;

import java.io.Serializable;

/**
 * @author <a href="http://github.com/asyrafduyshart">Asyraf Duyshart</a>
 * @date 5/26/2019
 * @since JDK1.8
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LogVO implements Serializable {

	private static final long serialVersionUID = 7088091769901805623L;

	private long id;

	private String ip;

	private String usr;
	private String clientId;
	private String path;
	private HttpMethod method;

	private long createdAt;
}
