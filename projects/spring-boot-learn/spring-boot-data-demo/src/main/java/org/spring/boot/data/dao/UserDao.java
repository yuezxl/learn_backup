package org.spring.boot.data.dao;

import org.spring.boot.data.model.UserModel;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<UserModel, Long>{

}
