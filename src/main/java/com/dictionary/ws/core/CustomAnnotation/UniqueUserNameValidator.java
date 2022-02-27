package com.dictionary.ws.core.CustomAnnotation;

import com.dictionary.ws.business.abstracts.UserService;
import com.dictionary.ws.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUserNameValidator implements ConstraintValidator<UniqueUserName, String> {

    @Autowired
    UserService userService;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        User user =userService.findByUserName(s);
        if(user!=null){
            return false;
        }
            return true;

    }
}
