import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.exception.student.user.UserNotFoundException;

@ControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<?>usernotfoundexception(UserNotFoundException ex){
		Map<String,String> map=new HashMap<>();
		map.put("message",ex.getMessage());
		return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
		
	}

}
