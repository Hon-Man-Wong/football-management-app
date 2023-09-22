package com.createment.footballmanager.Player;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class PlayerExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {PlayerNotFoundException.class})
    public ResponseEntity<?> handlePlayerNotFound(PlayerNotFoundException playerNotFoundException, WebRequest request) {
        return handleExceptionInternal(playerNotFoundException,
                playerNotFoundException.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}
