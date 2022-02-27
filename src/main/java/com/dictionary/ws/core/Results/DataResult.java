package com.dictionary.ws.core.Results;

public class DataResult<T> extends Result {

    private T data;


    public DataResult(boolean success, String message, T data) {
        super(success, message);
        this.data = data;
    }



    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
