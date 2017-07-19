package com.pharmerz.iphex.api.server.endpoint.exception.mapper;

import com.pharmerz.iphex.api.server.dto.ErrorData;
import org.springframework.dao.DuplicateKeyException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by ankur on 16-10-2016.
 */
@Provider
public class DuplicateKeyExceptionMapper implements ExceptionMapper<DuplicateKeyException> {
    @Override
    public Response toResponse(DuplicateKeyException ex) {
        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity(new ErrorData(1, ex.getMessage() ,"Contact http://www.pharmerz.com"))
                .type( MediaType.TEXT_PLAIN)
                .build();
    }
}
