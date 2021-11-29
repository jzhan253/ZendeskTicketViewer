package com.zendeskcodingchallenge.ZendeskTicketViewer.external;

public class ZendeskException extends RuntimeException{
    private final int code;
    public ZendeskException(String msg, int code){
        super(msg);
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

}
