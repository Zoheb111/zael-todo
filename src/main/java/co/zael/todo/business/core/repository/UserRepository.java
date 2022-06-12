package co.zael.todo.business.core.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.zael.todo.business.core.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	public User findById(int id);
}