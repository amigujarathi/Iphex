package com.pharmerz.iphex.api.server.controller.advice;

import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.pharmerz.iphex.api.server.dto.ErrorData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by ankur on 16-10-2016.
 */
@ControllerAdvice
public class UnrecognizedPropertyExceptionControllerAdvice {
    @ExceptionHandler(UnrecognizedPropertyException.class)
    public ResponseEntity<ErrorData> handleException(UnrecognizedPropertyException ex){
        return new ResponseEntity<>(new ErrorData(400, "This is an invalid request. The field " + ex.getPropertyName() + " is not recognized by the system.","Contact http://www.pharmerz.com"), HttpStatus.BAD_REQUEST);
    }

}
