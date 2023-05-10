package mx.gapsi.restfulservice.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Log4j2
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<ErrorMessage> handleNodataFoundException(
            NotFoundException exception, WebRequest request) {
        log.error(exception);
        exception.printStackTrace();
        return new ResponseEntity<>(new ErrorMessage(exception), HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler({BadRequestException.class})
    @ResponseBody
    public ResponseEntity<ErrorMessage> badRequest(HttpServletRequest request, Exception exception) {
        log.error(exception);
        exception.printStackTrace();
        return new ResponseEntity<>(new ErrorMessage(exception), HttpStatus.BAD_REQUEST);
    }

}
