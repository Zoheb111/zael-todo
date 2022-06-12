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

import co.zael.todo.business.core.entity.User;
import co.zael.todo.business.core.service.UserService;
import co.zael.todo.system.annotation.LogRequestResponse;
import co.zael.todo.system.exception.BaseBusinessException;
import co.zael.todo.system.response.StandardPagedResponse;
import co.zael.todo.system.response.StandardResponse;

@Controller 
@RequestMapping(path="/users") 
public class UserController {
	
  @Autowired
  private UserService userService;
  
  @LogRequestResponse
  @GetMapping(path="")
  @ResponseBody
  public ResponseEntity<StandardPagedResponse<Iterable<User>>> getAllUsers() throws BaseBusinessException {
	
		HttpStatus httpStatus = HttpStatus.OK;
		StandardPagedResponse<Iterable<User>> response = new StandardPagedResponse<Iterable<User>>(httpStatus, userService.getAllUsers(), "0000", "Users retrieved");
		return new ResponseEntity<>(response, httpStatus);  

  }
  
  @LogRequestResponse
  @GetMapping(path="/{id}") 
  @ResponseBody
  public ResponseEntity<StandardResponse<User>> getUserById(@PathVariable String id) throws Exception {
	  
	HttpStatus httpStatus = HttpStatus.OK;
	StandardResponse<User> response = new StandardResponse<User>(httpStatus, userService.getUserById(id), "0000", "User retrieved");
	return new ResponseEntity<>(response, httpStatus);  

  }

  @LogRequestResponse
  @PostMapping(path="") 
  @ResponseBody
  public ResponseEntity<StandardResponse<User>> addNewUser (@RequestBody User user) throws BaseBusinessException {
    
		HttpStatus httpStatus = HttpStatus.CREATED;
		StandardResponse<User> response = new StandardResponse<User>(httpStatus, userService.saveUser(user), "0000", "User created");
		return new ResponseEntity<>(response, httpStatus);
  }


}