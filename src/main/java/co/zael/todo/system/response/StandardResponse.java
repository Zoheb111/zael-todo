package co.zael.todo.system.response;

import org.springframework.http.HttpStatus;

public class StandardResponse<T> extends BaseResponse<T>  {

	public StandardResponse(HttpStatus httpStatus, T data, String appResponseCode, String message) {
		
		super(httpStatus, data, appResponseCode,message);

	}

}
