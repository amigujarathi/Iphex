package com.pharmerz.iphex.api.server.controller.advice;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.pharmerz.iphex.api.server.dto.ErrorData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by ankur on 16-10-2016.
 */
@ControllerAdvice
public class JsonMappingExceptionControllerAdvice {
    @ExceptionHandler(JsonMappingException.class)
    public ResponseEntity<ErrorData> handleException(JsonMappingException ex){
        return new ResponseEntity<>(new ErrorData(400, "This is an invalid request. At least one field format is not readable by the system." ,"Contact http://www.pharmerz.com"), HttpStatus.BAD_REQUEST);
    }

}
