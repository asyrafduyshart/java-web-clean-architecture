package com.asyraf.example.db.psql.listener;

import javax.persistence.PrePersist;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

/**
 * @author <a href="http://github.com/asyrafduyshart">Asyraf Duyshart</a>
 * @date 5/26/2019
 * @since JDK1.8
 */
public class PersistentListener {

	@PrePersist
	public void onCreate(Object object) {
		final String ID = "id";
		final String CREATED_AT = "createdAt";
		final String LAST_MODIFIED_AT = "lastModifiedAt";
	}
}
