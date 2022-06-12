package co.zael.todo.business.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import co.zael.todo.business.core.entity.Role;
import co.zael.todo.business.core.entity.projection.RoleProfile;
import co.zael.todo.business.core.repository.RoleRepository;
import co.zael.todo.system.exception.BaseBusinessException;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;

	public Iterable<RoleProfile> getAll() {
		return roleRepository.findAllProjectedBy();
	}

	public Role save(Role role) {

		roleRepository.save(role);
		return role;

	}

	public RoleProfile getById(String id) throws BaseBusinessException {

		int integerId = -1;
		RoleProfile role = null;

		try {
			integerId = Integer.parseInt(id);
			role = roleRepository.findById(integerId);

		} catch (Exception e) {
			throw new BaseBusinessException("Invalid Role Id", HttpStatus.BAD_REQUEST);
		}

		return role;
	}

}
