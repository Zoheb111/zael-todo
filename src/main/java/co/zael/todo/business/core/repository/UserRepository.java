package co.zael.todo.business.core.repository;

import org.springframework.data.repository.CrudRepository;

import co.zael.todo.business.core.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	public User findById(int id);
}