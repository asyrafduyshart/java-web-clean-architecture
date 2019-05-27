package com.asyraf.example.db.psql.domain;

import com.asyraf.example.db.psql.component.Transformer;
import com.asyraf.example.db.psql.po.UserPO;
import com.asyraf.example.db.psql.repo.CustomRepository;
import com.asyraf.example.domain.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Domain of {@link User}
 *
 * @author <a href="http://github.com/asyrafduyshart">Asyraf Duyshart</a>
 * @date 5/27/2019
 * @since JDK1.8
 */
@Service
@Transactional(readOnly = true)
public class UserDomain extends BaseDomain<User, Long> {
	public UserDomain(CustomRepository<User, Long> repository, Transformer transformer) {
		super(repository, transformer);
	}

	private UserPO po2Vo(User user) throws Exception {
  	return transformer.po2VO(UserPO.class, user);
  }
}
