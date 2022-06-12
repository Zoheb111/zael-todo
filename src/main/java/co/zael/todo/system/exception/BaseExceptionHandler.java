package co.zael.todo.system.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import co.zael.todo.system.response.ErrorResponse;
import co.zael.todo.system.util.LogUtil;

@ControllerAdvice
public class BaseExceptionHandler {
	
	@Value("${sys.stack-trace-in-api-response}")
	boolean stackTraceInApiResponse;
	
	@Value("${sys.stack-trace-in-log}")
	boolean stackTraceInLog;
	
    @ExceptionHandler({BaseBusinessException.class, BaseSystemException.class})
    public ResponseEntity<ErrorResponse<Object>> handleBaseExceptions(BaseException e) {

        HttpStatus status = e.getHttpStatus(); 
        
        String stackTrace = null;
        
        stackTrace = handleStackTrace(e);
        
        ErrorResponse<Object> errorResponse = new ErrorResponse<Object>(status, null, "1111", "", e.getExceptionCodePrefix(), e.getErrorMessage(), "", stackTrace);
        return new ResponseEntity<>(errorResponse, status);
    }
    
    
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorResponse<Object>> handleNullPointerExceptions(NullPointerException e) {

    HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR; 
    
    String stackTrace = null;
    
    stackTrace = handleStackTrace(e);

    ErrorResponse<Object> errorResponse = new ErrorResponse<Object>(status, null, "1111", "", "UNK-NULL", e.getMessage(), "", stackTrace);
    return new ResponseEntity<>(errorResponse, status);

    }
	


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse<Object>> handleExceptions(Exception e) {

    HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR; 
    String stackTrace = null;
    
    stackTrace = handleStackTrace(e);


    ErrorResponse<Object> errorResponse = new ErrorResponse<Object>(status, null, "1111", "", "UNK-EXC", e.getMessage(), "", stackTrace);
    return new ResponseEntity<>(errorResponse, status);

    }
    
    private String getStackTrace(Exception e){
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        e.printStackTrace(printWriter);
        return stringWriter.toString();
    }
       
    private String handleStackTrace(Exception e) {
    	
    	String stackTrace = "";
        if(stackTraceInApiResponse || stackTraceInLog) {
        	
        	stackTrace = getStackTrace(e);
        }
        
        if(stackTraceInLog) {
        	LogUtil.printStackTrace(stackTrace);
        }
        
        return stackTraceInApiResponse ? stackTrace : "";
        
    }
}
