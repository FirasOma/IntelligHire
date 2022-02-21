package de.tekup.intellighire.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beanconfig {

    @Bean
    public ModelMapper getModelMapper(){
     return  new ModelMapper();
    }
}
