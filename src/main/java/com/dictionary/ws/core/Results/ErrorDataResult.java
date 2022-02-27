package com.dictionary.ws.core.Results;

public class ErrorDataResult<T> extends DataResult {


    public ErrorDataResult( String message, T data) {
        super(false, message, data);
    }
}
