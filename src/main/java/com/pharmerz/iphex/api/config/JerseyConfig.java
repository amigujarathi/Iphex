package com.pharmerz.iphex.api.config;

import com.pharmerz.iphex.api.server.endpoint.exception.mapper.*;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

/**
 * Created by ankur on 04-10-2016.
 */
@Configuration
@ApplicationPath("/api/v2")
public class JerseyConfig extends ResourceConfig{

    public JerseyConfig(){
        registerEndpoint();
        registerExceptionMapper();
    }

    private void registerExceptionMapper() {
        register(ExceptionExceptionMapper.class);
        register(JsonParseExceptionMapper.class);
        register(JsonMappingExceptionMapper.class);
        register(UnrecognizedPropertyExceptionMapper.class);
        register(DuplicateKeyExceptionMapper.class);
    }

    private void registerEndpoint() {

    }
}
