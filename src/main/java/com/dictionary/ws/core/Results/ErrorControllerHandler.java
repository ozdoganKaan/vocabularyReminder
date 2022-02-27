package com.dictionary.ws.core.Results;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ErrorControllerHandler implements ErrorController {

    @Autowired
    private ErrorAttributes errorAttributes;

    @RequestMapping("/error")
    Result errorHandler(WebRequest webRequest){
      Map<String,Object> attributes= errorAttributes.getErrorAttributes(webRequest,ErrorAttributeOptions.of(ErrorAttributeOptions.Include.MESSAGE, ErrorAttributeOptions.Include.BINDING_ERRORS));

            String message = (String) attributes.get("message");
            Result result = new Result(false,message);

            if(attributes.containsKey("errors")){
                List<FieldError> fieldErrorList= (List<FieldError>) attributes.get("errors");
                Map<String,String> validationErrors=new HashMap<>();
                for(FieldError fieldError: fieldErrorList) {
                    validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
                }
                result.setErrorList(validationErrors);
            }

            return result;
    }


    public String getErrorPath(){
        return "/error";
    }
}
