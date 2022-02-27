package com.dictionary.ws.core.Results;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result {


    private boolean success;


    private String message;


    private Map<String,String> errorList=new HashMap<>();


    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }


    public Result(boolean success) {
        this.success = success;
    }

    public Result() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, String> getErrorList() {
        return errorList;
    }

    public void setErrorList(Map<String, String> errorList) {
        this.errorList = errorList;
    }
}
