package com.pharmerz.iphex.api.config;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;
import org.springframework.jdbc.support.SQLExceptionTranslator;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by ankur on 14-08-2016.
 */
@Configuration
@EnableAsync
public class AppConfig {










    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AmazonSNS amazonSNS(@Value("${aws.iam.accessKey}") String accessKey, @Value("${aws.iam.secretKey}") String sercretKey){
        AmazonSNSClient sns = new AmazonSNSClient(new BasicAWSCredentials(accessKey, sercretKey));
        sns.setRegion(Region.getRegion(Regions.AP_SOUTHEAST_1));
        return sns;
    }


    @Bean
    public BeanPostProcessor beanPostProcessor(){
        return new BeanPostProcessor() {
            @Override
            public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
                return bean;
            }

            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                if(bean instanceof JdbcTemplate){
                    JdbcTemplate jdbcTemplate = (JdbcTemplate) bean;
                    SQLExceptionTranslator exceptionTranslator = jdbcTemplate.getExceptionTranslator();
                    if(exceptionTranslator instanceof SQLErrorCodeSQLExceptionTranslator){
                        SQLErrorCodeSQLExceptionTranslator errorCodeExceptionTranslator = (SQLErrorCodeSQLExceptionTranslator) exceptionTranslator;
                        errorCodeExceptionTranslator.getSqlErrorCodes().setCustomTranslations(
                               /* new CustomSQLErrorCodesTranslation(){{
                                    this.setErrorCodes("23505");
                                    this.setExceptionClass(CandidateKeyViolationException.class);
                                }} */
                        );
                    }
                }
                return bean;
            }
        };
    }

}
