package com.dictionary.ws.core.Results;

public class SuccessDataResult<T> extends DataResult {



    public SuccessDataResult( String message, T data) {
        super(true, message, data);
    }


}
