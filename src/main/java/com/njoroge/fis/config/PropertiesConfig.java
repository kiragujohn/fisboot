
package com.njoroge.fis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 *
 * @author John Njoroge
 * @date 09/05/2019
 **/

@Configuration
public class PropertiesConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer
            propertySourcesPlaceholderConfigurer() {

        return new PropertySourcesPlaceholderConfigurer();
    }
}
