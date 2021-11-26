package com.zendeskcodingchallenge.ZendeskTicketViewer.util;

import lombok.Data;
import java.io.Serializable;

@Data
public class Result<T> implements Serializable {
    private int resultCode;
    private String message;
    private T data;
    public Result(){
    }
    public Result(int resultCode, String message){
        this.resultCode = resultCode;
        this.message = message;
    }

    @Override
    public String toString() {
        return "Result{" +
                "resultCode=" + resultCode +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

}
