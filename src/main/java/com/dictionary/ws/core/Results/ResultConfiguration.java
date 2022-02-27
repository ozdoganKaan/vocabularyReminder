package com.dictionary.ws.core.Results;

import com.dictionary.ws.entities.DTO.UserDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ResultConfiguration {

    @Bean(name = "result")
    public Result resultBean(){
        return new Result();
    }
    @Bean
    public ErrorResult errorResultBean(){
        return new ErrorResult();
    }
    @Bean
    public SuccessResult succesResultBean(){
        return new SuccessResult();
    }

    @Bean
    public UserDTO getUserDTO(){
        return new UserDTO();
    }
}
