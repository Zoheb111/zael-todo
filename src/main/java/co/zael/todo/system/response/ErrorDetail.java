package co.zael.todo.system.response;

public class ErrorDetail {

	private String errorCode; 
	private String errorMessage;
	private String errorReference;
	private String errorTrace;
	private String suberrors;
	public ErrorDetail(String errorCode, String errorMessage, String errorReference, String errorTrace) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.errorReference = errorReference;
		this.errorTrace = errorTrace;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public String getErrorReference() {
		return errorReference;
	}
	public String getErrorTrace() {
		return errorTrace;
	}
	@Override
	public String toString() {
		return "ErrorDetail [errorCode=" + errorCode + ", errorMessage=" + errorMessage + ", errorReference="
				+ errorReference + ", errorTrace=" + errorTrace + ", suberrors=" + suberrors + "]";
	}

	
	
	
}
