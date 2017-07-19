package com.pharmerz.iphex;

import com.pharmerz.iphex.api.config.AppConfig;
import com.pharmerz.iphex.api.config.SpringWebMvcConfig;
import com.pharmerz.iphex.api.server.aws.sns.SNSMobilePush;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Import({AppConfig.class, SpringWebMvcConfig.class})
public class IphexApplication {

    public static void main(String[] args) {
        SpringApplication.run(IphexApplication.class, args);
    }
}

@Component
class IphexApplicationCommandLineRunner implements CommandLineRunner {


    @Override
    public void run(String... strings) throws Exception {


    }
}
