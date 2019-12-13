package exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<GenericExceptionModel> handleAllExceptions(Exception ex, WebRequest request) {

		GenericExceptionModel exceptionResponse = new GenericExceptionModel(new Date(), ex.getMessage(),
				request.getDescription(true));

		return new ResponseEntity<GenericExceptionModel>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
