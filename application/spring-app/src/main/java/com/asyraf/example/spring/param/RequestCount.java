package com.asyraf.example.spring.param;

import lombok.*;

import java.io.Serializable;

/**
 * @author <a href="http://github.com/asyrafduyshart">Asyraf Duyshart</a>
 * @date 5/26/2019
 * @since JDK1.8
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class RequestCount implements Serializable {

	private String key;
	private int count = 0;
	private final long firstReqAt = System.currentTimeMillis();
}
