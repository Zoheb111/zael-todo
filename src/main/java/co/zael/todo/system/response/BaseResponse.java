package co.zael.todo.system.response;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class BaseResponse<T> {
	@JsonIgnore
	private HttpStatus httpStatus;
	private String httpStatusCode;
	private String httpStatusName;
	private String apiResponseCode;
	private String message;
	private Object data;
	private ErrorDetail errorDetails;

	
	public BaseResponse(HttpStatus httpStatus, T data, String appResponseCode, String message) {
		
		this(httpStatus, data, appResponseCode, message, "", "", "","");
		
	}
	
	
	
	public BaseResponse(HttpStatus httpStatus, T data, String apiResponseCode, String message, String errorCode, String errorMessage, String errorReference, String errorTrace) {
		super();
		this.httpStatus = httpStatus;
		this.httpStatusCode = String.valueOf(httpStatus.value());
		this.httpStatusName = httpStatus.name();
		this.message = message;
		this.data = data;
		this.apiResponseCode = apiResponseCode;
		this.errorDetails = new ErrorDetail(errorCode,errorMessage,errorReference,errorTrace);

	}
	public String getHttpStatusCode() {
		return httpStatusCode;
	}
	public String getHttpStatusName() {
		return httpStatusName;
	}
	public Object getData() {
		return data;
	}
	public String getApiResponseCode() {
		return apiResponseCode;
	}
	public String getMessage() {
		return message;
	}

	public ErrorDetail getErrorDetails() {
		return errorDetails;
	}



	public HttpStatus getHttpStatus() {
		return httpStatus;
	}



	@Override
	public String toString() {
		return "BaseResponse [httpStatus=" + httpStatus + ", httpStatusCode=" + httpStatusCode + ", httpStatusName="
				+ httpStatusName + ", apiResponseCode=" + apiResponseCode + ", message=" + message + ", data=" + data
				+ ", errorDetails=" + errorDetails + "]";
	}

	

	
	
}
