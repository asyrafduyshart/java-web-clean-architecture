package com.asyraf.example.db.psql.po;

import com.asyraf.example.db.psql.listener.PersistentListener;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author <a href="http://github.com/asyrafduyshart">Asyraf Duyshart</a>
 * @date 5/26/2019
 * @since JDK1.8
 */
@Entity
@EntityListeners(PersistentListener.class)
@Table(name = "User")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserPO {

	private static final long serialVersionUID = -6004454109313475045L;

	@GenericGenerator(
		name = "accountSequenceGenerator",
		strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
		parameters = {
			@Parameter(name = "sequence_name", value = "accounts_seq"),
			@Parameter(name = "initial_value", value = "1"),
			@Parameter(name = "increment_size", value = "1")
		}
	)
	@Id
	@GeneratedValue(generator = "accountSequenceGenerator")
	@Column(updatable = false)
	private long id;

	@Column(nullable = false)
	private String account;
	private String email;
	private String password;
	private String lastName;
	private String firstName;
}
