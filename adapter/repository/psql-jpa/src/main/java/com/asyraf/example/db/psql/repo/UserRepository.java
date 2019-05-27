package com.asyraf.example.db.psql.repo;

import com.asyraf.example.db.psql.po.UserPO;
import java.util.Optional;

/**
 * @author <a href="http://github.com/asyrafduyshart">Asyraf Duyshart</a>
 * @date 5/26/2019
 * @since JDK1.8
 */
public interface UserRepository extends CustomRepository<UserPO, Long> {
	Optional<UserPO> findById(Long id);
}
