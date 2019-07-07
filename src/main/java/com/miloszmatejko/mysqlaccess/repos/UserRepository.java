package com.miloszmatejko.mysqlaccess.repos;

import org.springframework.data.repository.CrudRepository;

import com.miloszmatejko.mysqlaccess.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
