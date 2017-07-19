package com.pharmerz.iphex.api.config;

import com.pharmerz.iphex.api.jpa.LocalContainerEntityManagerExtendedFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

/**
 * Created by ankur on 13-08-2016.
 */
@Configuration
@EnableJpaAuditing(dateTimeProviderRef = "utcDateTimeProvider")
public class JpaConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(JdbcTemplate jdbcTemplate){
        LocalContainerEntityManagerExtendedFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerExtendedFactoryBean();
        entityManagerFactoryBean.setDataSource(jdbcTemplate.getDataSource());
        entityManagerFactoryBean.setPackagesToScan("com.pharmerz.iphex.api.server.domain.model");
        entityManagerFactoryBean.setPersistenceUnitName("iphexPU");
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter(){{
            setDatabase(Database.ORACLE);
        }});


        entityManagerFactoryBean.setSqlExceptionTranslator(jdbcTemplate.getExceptionTranslator());
        return entityManagerFactoryBean;
    }
}
