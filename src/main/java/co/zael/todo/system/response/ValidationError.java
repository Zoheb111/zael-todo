package co.zael.todo.system.response;

public class ValidationError extends SubError{
	   private String object;
	   private String field;
	   private Object rejectedValue;
	   private String message;

	   ValidationError(String object, String message) {
	       this.object = object;
	       this.message = message;
	   }
	   
	   

	public ValidationError(String object, String field, Object rejectedValue, String message) {
		super();
		this.object = object;
		this.field = field;
		this.rejectedValue = rejectedValue;
		this.message = message;
	}



	public String getObject() {
		return object;
	}

	public String getField() {
		return field;
	}

	public Object getRejectedValue() {
		return rejectedValue;
	}

	public String getMessage() {
		return message;
	}
	   
	   
}
