package com.pharmerz.iphex.api.server.controller.advice;

import com.pharmerz.iphex.api.server.dto.ErrorData;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by ankur on 16-10-2016.
 */
@ControllerAdvice
public class DublicateKeyExceptionControllerAdvice {
    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<ErrorData> handleException(DuplicateKeyException ex){
        return new ResponseEntity<>(new ErrorData(1, ex.getMessage() ,"Contact http://www.pharmerz.com"), HttpStatus.BAD_REQUEST);
    }

}
