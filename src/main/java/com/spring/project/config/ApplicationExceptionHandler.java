package com.spring.project.config;

import com.spring.project.constant.ApplicationConstants;
import com.spring.project.dto.Response;
import com.spring.project.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public void defaultExceptionHandler() {

    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Response> userNotFoundExceptionHandler(UserNotFoundException userNotFoundException) {
        Response exceptionResponse = new Response.ResponseBuilder()
                .setStatus(HttpStatus.NOT_FOUND)
                .setErrorCode(ApplicationConstants.ErrorCodes.ZERO_RECORD.getValue())
                .setMessage(userNotFoundException.getMessage())
                .setDetails(userNotFoundException.getDetail())
                .build();

        return new ResponseEntity<>(exceptionResponse, exceptionResponse.getHttpStatus());
    }

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<Response> invalidInputExceptionHandler(InvalidInputException invalidInputException) {
        Response exceptionResponse = new Response.ResponseBuilder()
                .setStatus(HttpStatus.BAD_REQUEST)
                .setErrorCode(ApplicationConstants.ErrorCodes.MISSING_PARAMETER.getValue())
                .setMessage(invalidInputException.getMessage())
                .setDetails(invalidInputException.getDetail())
                .build();

        return new ResponseEntity<>(exceptionResponse, exceptionResponse.getHttpStatus());
    }

    @ExceptionHandler(GeneralException.class)
    public ResponseEntity<Response> generalExceptionHandler(GeneralException generalException) {
        Response exceptionResponse = new Response.ResponseBuilder()
                .setStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .setErrorCode(ApplicationConstants.ErrorCodes.GENERAL_ERROR.getValue())
                .setMessage(generalException.getMessage())
                .setDetails(generalException.getDetail())
                .build();

        return new ResponseEntity<>(exceptionResponse, exceptionResponse.getHttpStatus());
    }

    @ExceptionHandler(UserNotRegisteredException.class)
    public ResponseEntity<Response> userNotRegisteredExceptionHandler(UserNotRegisteredException userNotRegisteredException) {
        Response exceptionResponse = new Response.ResponseBuilder()
                .setStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .setErrorCode(ApplicationConstants.ErrorCodes.USER_NOT_REGISTERED.getValue())
                .setMessage(userNotRegisteredException.getMessage())
                .setDetails(userNotRegisteredException.getDetail())
                .build();

        return new ResponseEntity<>(exceptionResponse, exceptionResponse.getHttpStatus());
    }

    @ExceptionHandler(RoleNotFoundException.class)
    public ResponseEntity<Response> roleNotFoundExceptionHandler(RoleNotFoundException roleNotFoundException) {
        Response exceptionResponse = new Response.ResponseBuilder()
                .setStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .setErrorCode(ApplicationConstants.ErrorCodes.ZERO_RECORD.getValue())
                .setMessage(roleNotFoundException.getMessage())
                .setDetails(roleNotFoundException.getDetail())
                .build();

        return new ResponseEntity<>(exceptionResponse, exceptionResponse.getHttpStatus());
    }

    @ExceptionHandler(UnableToLoginException.class)
    public ResponseEntity<Response> unableToLoginExceptionHandler(UnableToLoginException unableToLoginException) {
        Response exceptionResponse = new Response.ResponseBuilder()
                .setStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .setErrorCode(ApplicationConstants.ErrorCodes.LOGIN_FAILED.getValue())
                .setMessage(unableToLoginException.getMessage())
                .setDetails(unableToLoginException.getDetail())
                .build();

        return new ResponseEntity<>(exceptionResponse, exceptionResponse.getHttpStatus());
    }

}