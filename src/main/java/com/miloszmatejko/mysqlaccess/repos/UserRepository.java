package com.miloszmatejko.mysqlaccess.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.miloszmatejko.mysqlaccess.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	List<User> findByName(String name);
	void deleteById(Integer id);
}
