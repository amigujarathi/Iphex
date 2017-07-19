package com.pharmerz.iphex.api.server.endpoint.exception.mapper;


import com.pharmerz.iphex.api.server.dto.ErrorData;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by ankurpathak on 02-02-2016.
 */
@Provider
public class ExceptionExceptionMapper implements ExceptionMapper<Throwable> {
    @Override
    public Response toResponse(Throwable ex) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(new ErrorData(500, ex.getMessage(),"Contact http://www.pharmerz.com"))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
