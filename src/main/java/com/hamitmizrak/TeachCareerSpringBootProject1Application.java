package com.hamitmizrak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//exclude:dahil etmemek
@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
        org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class
}
)

//AuditorAwere
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class TeachCareerSpringBootProject1Application {

    public static void main(String[] args) {
        SpringApplication.run(TeachCareerSpringBootProject1Application.class, args);

        //JOptionalPane Kullanmak icin
        System.setProperty("java.awt.headless", "false");
    }

}
