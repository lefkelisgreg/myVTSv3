package gr.hua.dit.dsteam39.myVTSv3.ExceptionsHandler;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Greg Lefkelis lef
 * DS Team id: 39
 * @project myVTSv3
 */
@ControllerAdvice
public class GlobalControllerExceptions {

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public void handleConflict() {}
}
