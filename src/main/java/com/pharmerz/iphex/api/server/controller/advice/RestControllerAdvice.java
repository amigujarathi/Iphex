package com.pharmerz.iphex.api.server.controller.advice;

import org.springframework.data.rest.webmvc.RepositoryRestExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * Created by ankur on 22-10-2016.
 */
@ControllerAdvice(basePackageClasses = RepositoryRestExceptionHandler.class)
public class RestControllerAdvice {

}
