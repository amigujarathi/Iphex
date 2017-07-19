package com.pharmerz.iphex.api.server.controller.advice;

import com.fasterxml.jackson.core.JsonParseException;
import com.pharmerz.iphex.api.server.dto.ErrorData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by ankur on 16-10-2016.
 */
@ControllerAdvice
public class JsonParseExceptionControllerAdvice {
    @ExceptionHandler(JsonParseException.class)
    public ResponseEntity<ErrorData> handleException(JsonParseException ex){
        return new ResponseEntity<>(new ErrorData(400, "This is an invalid json. The request can not be parsed." ,"Contact http://www.pharmerz.com"), HttpStatus.BAD_REQUEST);
    }

}
