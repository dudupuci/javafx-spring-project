package com.app.javafx.system.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:specifications.properties")
public class SpecificationsConfig {
    @Value("${system.help.about.message}")
    private String aboutMessage;

    @Bean
    public String getAboutMessage() {
        return aboutMessage;
    }
}