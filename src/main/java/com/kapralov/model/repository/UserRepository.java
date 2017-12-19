package com.kapralov.model.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kapralov.model.data.User;

@Repository("userRepository")
public interface UserRepository extends CrudRepository<User, Long>{
	
	void delete(User entity);
	List<User> findAll();
	User findOne(Long id);
	User save(User entity);
	
}
