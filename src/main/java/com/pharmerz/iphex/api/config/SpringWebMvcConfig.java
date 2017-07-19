package com.pharmerz.iphex.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by ankur on 14-08-2016.
 */
@Configuration
public class SpringWebMvcConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private Environment env;

    @Autowired
    private PasswordEncoder passwordEncoder;



    /*
    @Bean
    @Profile("development")
    public MappedInterceptor dataRestDevelopmentInterceptor() {
        return new MappedInterceptor(new String[]{"/api/v1/**"}, new HandlerInterceptorAdapter() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

                UserView userView = new UserView();
                userView.setUsername("admin");
                userView.setPassword(passwordEncoder.encode("password"));
                CustomUserDetails customUserDetails = new CustomUserDetails(userView, Arrays.asList("ROLE_ADMIN"));
                Authentication authentication = new UsernamePasswordAuthenticationToken(customUserDetails, customUserDetails.getPassword());
                SecurityContextHolder.getContext().setAuthentication(authentication);
                return super.preHandle(request, response, handler);
            }
        });
    }


    */


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/access").setViewName("access");

    }



}
