package co.zael.todo.system.exception;

import org.springframework.http.HttpStatus;

public class BaseBusinessException extends BaseException{


	private static final long serialVersionUID = 1L;

	public BaseBusinessException(String errorMessage, HttpStatus httpStatus) {
		super("BUS-", errorMessage, httpStatus);
	}
	

}
