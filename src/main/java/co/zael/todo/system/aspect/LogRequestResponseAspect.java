package co.zael.todo.system.aspect;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.stereotype.Component;

import co.zael.todo.system.util.LogUtil;

@Aspect
@Component
public class LogRequestResponseAspect {
	
	@Around("@annotation(co.zael.todo.system.annotation.LogRequestResponse)")
	public Object logRequestResponse(ProceedingJoinPoint joinPoint) throws Throwable {
		
		UUID identifier = UUID.randomUUID();
		

		logArgs(joinPoint,identifier.toString());
		
		Object returnedObject = joinPoint.proceed();
		
		logReturnValue(returnedObject,identifier.toString());
		
	    return returnedObject;
	}
	
	private void logArgs(ProceedingJoinPoint joinPoint, String identifier){
		
		CodeSignature codeSignature = (CodeSignature) joinPoint.getSignature();

		String[] names = codeSignature.getParameterNames(); 
		Object[] args = joinPoint.getArgs(); 
		Map<String, Object> fieldToValue = new HashMap<>(); 
		for (int i = 0; i < names.length; i++) 
		{ fieldToValue.put(names[i], args[i]); }



		LogUtil.debug(identifier +": "+ fieldToValue);

	}
	
	private void logReturnValue(Object returnObject, String identifier) {
		LogUtil.debug(identifier +": "+returnObject);
	}
}
