package com.sang.mhxy.tool.common.exception;


import com.sang.mhxy.tool.common.constants.ResultConstants;

/**
 * Controller返回结果异常
 */
public class ResultException extends Exception {
    private String status;
    private String msg;

    public ResultException(String msg) {
        this(msg, ResultConstants.CODE_ERROR);
    }

    public ResultException(String msg, String status) {
        setMsg(msg);
        setStatus(status);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
