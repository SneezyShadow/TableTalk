package com.shongrimes.tabletalk.data;

import com.shongrimes.tabletalk.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}
