package co.zael.todo.business.core.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.zael.todo.business.core.entity.Role;
import co.zael.todo.business.core.entity.projection.RoleProfile;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

	public RoleProfile findById(int id);
	
	public Iterable<RoleProfile> findAllProjectedBy();
	
}
