package co.zael.todo.business.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import co.zael.todo.business.core.entity.User;
import co.zael.todo.business.core.repository.UserRepository;
import co.zael.todo.system.exception.BaseBusinessException;

@Service
public class UserService {

	  @Autowired 
	  private UserRepository userRepository;
	  
	  
	  public Iterable<User> getAllUsers(){
		  return userRepository.findAll();
	  }
	  
	  public User saveUser(User user) {
		  
	    userRepository.save(user);
	    return user;
	    
	  }
	  
	  
	  public User getUserById(String id) throws BaseBusinessException {
		  
		  int integerId = -1;
		  User user = null;
		  
		  try {
			  integerId = Integer.parseInt(id);
			  user = userRepository.findById(integerId);
			  
		  }catch(Exception e) {
			  throw new BaseBusinessException("Invalid User Id", HttpStatus.BAD_REQUEST);
		  }
		  
		  return user;
	  }

	    
}
