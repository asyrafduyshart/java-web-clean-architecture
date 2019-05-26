package com.asyraf.example.spring.param;

import com.asyraf.example.spring.anotation.NotNullField;
import org.springframework.http.HttpMethod;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Size;

/**
 * @author <a href="http://github.com/asyrafduyshart">Asyraf Duyshart</a>
 * @date 5/26/2019
 * @since JDK1.8
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginParam {

	@NotNullField(method = HttpMethod.POST, message = "usr cannot be null.")
	@Size(min = 4, max = 50, message = "usr must greater than or equal to 4 and less than or equal to 50.")
	private String usr;

	@NotNullField(method = HttpMethod.POST, message = "pwd cannot be null.")
	@Size(min = 4, max = 16, message = "pwd must greater than or equal to 4 and less than or equal to 16.")
	private String pwd;
}
