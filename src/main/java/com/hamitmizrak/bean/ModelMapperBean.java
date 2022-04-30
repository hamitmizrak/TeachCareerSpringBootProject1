package com.hamitmizrak.bean;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//Baca Sil

@Configuration
public class ModelMapperBean {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
