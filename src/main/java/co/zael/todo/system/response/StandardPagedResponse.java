package co.zael.todo.system.response;

import org.springframework.http.HttpStatus;

public class StandardPagedResponse<T> extends BaseResponse<T>{

	public StandardPagedResponse(HttpStatus httpStatus, T data, String appResponseCode, String message) {
		super(httpStatus, data, appResponseCode, message);
		
	}
	


}
