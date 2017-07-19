package com.pharmerz.iphex.api.server.endpoint.exception.mapper;

import com.fasterxml.jackson.core.JsonParseException;
import com.pharmerz.iphex.api.server.dto.ErrorData;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by ankur on 16-10-2016.
 */
@Provider
public class JsonParseExceptionMapper implements ExceptionMapper<JsonParseException> {
    @Override
    public Response toResponse(JsonParseException ex) {
        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity(new ErrorData(400, "This is an invalid json. The request can not be parsed." ,"Contact http://www.pharmerz.com"))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
