package com.bipinet.animalsupersore.api.exception;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalDefaultExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(HttpClientErrorException.class)
  public ResponseEntity<ErrorResponse> handleHttpClientErrorException(HttpClientErrorException ex,
      WebRequest webRequest) {
    ErrorResponse error = ImmutableErrorResponse.builder()
        .timestamp(LocalDateTime.now())
        .error(ex.getMessage())
        .status(ex.getStatusCode().value())
        .build();

    return new ResponseEntity<>(error, ex.getStatusCode());
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponse> handleAllOtherExceptions(Exception ex,
      WebRequest webRequest) {

    ErrorResponse error = ImmutableErrorResponse.builder()
        .timestamp(LocalDateTime.now())
        .error(ex.getMessage())
        .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
        .build();

    return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
  }

}


