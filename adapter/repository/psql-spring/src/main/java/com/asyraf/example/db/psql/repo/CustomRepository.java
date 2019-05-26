package com.asyraf.example.db.psql.repo;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author <a href="http://github.com/asyrafduyshart">Asyraf Duyshart</a>
 * @date 5/26/2019
 * @since JDK1.8
 */
@NoRepositoryBean
interface CustomRepository<T, ID extends Serializable>
	extends JpaSpecificationExecutor<T>, JpaRepository<T, ID> {
}
