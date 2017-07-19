package com.pharmerz.iphex.api.server.domain.audit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * Created by ankur on 13-08-2016.
 */
@Component
public class UsernameAuditorAware implements AuditorAware<String> {

    @Autowired
    private Environment env;

    @Override
    public String getCurrentAuditor() {
        return "admin";
    }
}
