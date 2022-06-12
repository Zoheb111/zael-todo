package co.zael.todo.business.core.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.zael.todo.business.core.entity.Role;
import co.zael.todo.business.core.entity.projection.RoleProfile;
import co.zael.todo.business.core.service.RoleService;
import co.zael.todo.system.annotation.LogRequestResponse;
import co.zael.todo.system.exception.BaseBusinessException;
import co.zael.todo.system.response.StandardPagedResponse;
import co.zael.todo.system.response.StandardResponse;

@Controller 
@RequestMapping(path="/roles") 
public class RoleController {
	
  @Autowired
  private RoleService roleService;
  
  @LogRequestResponse
  @GetMapping(path="")
  @ResponseBody
  public ResponseEntity<StandardPagedResponse<Iterable<RoleProfile>>> getAllUsers() throws BaseBusinessException {
	
		HttpStatus httpStatus = HttpStatus.OK;
		StandardPagedResponse<Iterable<RoleProfile>> response = new StandardPagedResponse<Iterable<RoleProfile>>(httpStatus, roleService.getAll(), "0000", "Roles retrieved");
		return new ResponseEntity<>(response, httpStatus);  

  }
  
  @LogRequestResponse
  @GetMapping(path="/{id}") 
  @ResponseBody
  public ResponseEntity<StandardResponse<RoleProfile>> getUserById(@PathVariable String id) throws Exception {
	  
	HttpStatus httpStatus = HttpStatus.OK;
	StandardResponse<RoleProfile> response = new StandardResponse<RoleProfile>(httpStatus, roleService.getById(id), "0000", "Role retrieved");
	return new ResponseEntity<>(response, httpStatus);  

  }

  @LogRequestResponse
  @PostMapping(path="") 
  @ResponseBody
  public ResponseEntity<StandardResponse<Role>> addNewUser (@RequestBody Role role) throws BaseBusinessException {
    
		HttpStatus httpStatus = HttpStatus.CREATED;
		StandardResponse<Role> response = new StandardResponse<Role>(httpStatus, roleService.save(role), "0000", "Role created");
		return new ResponseEntity<>(response, httpStatus);
  }


}