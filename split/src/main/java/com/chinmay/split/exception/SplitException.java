package com.chinmay.split.exception;

public class SplitException extends RuntimeException{

    public String errMsg;

    public int  errCode;

    public SplitException(String errMsg, int errCode) {
        this.errMsg = errMsg;
        this.errCode = errCode;
    }

    public SplitException(String message, String errMsg, int errCode) {
        super(message);
        this.errMsg = errMsg;
        this.errCode = errCode;
    }

    public SplitException(String message, Throwable cause, String errMsg, int errCode) {
        super(message, cause);
        this.errMsg = errMsg;
        this.errCode = errCode;
    }

    public SplitException(Throwable cause, String errMsg, int errCode) {
        super(cause);
        this.errMsg = errMsg;
        this.errCode = errCode;
    }

    public SplitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String errMsg, int errCode) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errMsg = errMsg;
        this.errCode = errCode;
    }
}
