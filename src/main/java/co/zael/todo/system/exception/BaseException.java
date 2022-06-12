package co.zael.todo.system.exception;

import org.springframework.http.HttpStatus;

public class BaseException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private HttpStatus httpStatus;
	private String errorMessage;
	private StringBuilder exceptionCodePrefix = new StringBuilder();
	
	protected BaseException(String prefix, String errorMessage, HttpStatus httpStatus){

		if(errorMessage == null) {
			errorMessage = "There was a error.";
		}
		
		if(httpStatus == null) {
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		this.exceptionCodePrefix.append(prefix);
		this.errorMessage = errorMessage;
		this.httpStatus = httpStatus;
		
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public String getExceptionCodePrefix() {
		return exceptionCodePrefix.toString();
	}


}
