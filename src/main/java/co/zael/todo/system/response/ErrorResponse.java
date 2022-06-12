package co.zael.todo.system.response;

import org.springframework.http.HttpStatus;

public class ErrorResponse<T> extends BaseResponse<T> {

	public ErrorResponse(HttpStatus httpStatus, T data, String appResponseCode, String message,	String errorCode, String errorMessage, String errorReference, String errorTrace) {

		super(httpStatus, data, appResponseCode,message, errorCode, errorMessage, errorReference, errorTrace);
	}


	
}
