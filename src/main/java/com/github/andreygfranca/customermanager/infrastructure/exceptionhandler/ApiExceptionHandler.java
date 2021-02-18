package com.github.andreygfranca.customermanager.infrastructure.exceptionhandler;

import com.github.andreygfranca.customermanager.core.usecase.exception.NotFoundException;
import java.time.OffsetDateTime;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
  
  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<?> handleNotFoundException(NotFoundException ex, WebRequest request) {
    HttpStatus status = HttpStatus.NOT_FOUND;
    
    Problem problem = Problem.builder()
        .status(status.value())
        .title("Not found")
        .detail(ex.getMessage())
        .timestamp(OffsetDateTime.now())
        .build();
    
    return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
  }
  
}
