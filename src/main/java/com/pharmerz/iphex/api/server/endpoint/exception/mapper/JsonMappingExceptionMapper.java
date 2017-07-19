package com.pharmerz.iphex.api.server.endpoint.exception.mapper;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.pharmerz.iphex.api.server.dto.ErrorData;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by ankur on 16-10-2016.
 */
@Provider
public class JsonMappingExceptionMapper implements ExceptionMapper<JsonMappingException> {
    @Override
    public Response toResponse(JsonMappingException e) {
        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity(new ErrorData(400, "This is an invalid request. At least one field format is not readable by the system." ,"Contact http://www.pharmerz.com"))
                .type( MediaType.TEXT_PLAIN)
                .build();
    }
}
