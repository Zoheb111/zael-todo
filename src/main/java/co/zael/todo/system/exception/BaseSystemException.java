package co.zael.todo.system.exception;

import org.springframework.http.HttpStatus;

public class BaseSystemException extends BaseException{

	private static final long serialVersionUID = 1L;
	
	public BaseSystemException(String message, HttpStatus httpStatus) {
		super("SYS-", message, httpStatus);
	}

	

}
