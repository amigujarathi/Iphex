package com.pharmerz.iphex.api.server.endpoint.exception.mapper;

import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.pharmerz.iphex.api.server.dto.ErrorData;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by ankur on 16-10-2016.
 */
@Provider
public class UnrecognizedPropertyExceptionMapper implements ExceptionMapper<UnrecognizedPropertyException> {
    @Override
    public Response toResponse(UnrecognizedPropertyException ex) {
        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity(new ErrorData(400, "This is an invalid request. The field " + ex.getPropertyName() + " is not recognized by the system.","Contact http://www.pharmerz.com"))
                .type( MediaType.TEXT_PLAIN)
                .build();
    }
}
