package com.sang.mhxy.tool.common.model;

import com.sang.mhxy.tool.common.constants.ResultConstants;
import com.sang.mhxy.tool.common.exception.ResultException;

import java.util.HashMap;
import java.util.Map;

public class Result {
    private String status;
    private String message;
    private Map<String, Object> data;

    private Result() {
    }

    public static Result ok() {
        Result result = new Result();
        result.setStatus(ResultConstants.CODE_OK);
        return result;
    }

    public static Result error(String message) {
        Result result = new Result();
        result.setStatus(ResultConstants.CODE_ERROR);
        result.setMessage(message);
        return result;
    }

    public static Result exception(Exception e) {
        if(e instanceof ResultException){
            ResultException e2 = (ResultException) e;
            Result r = Result.error(e2.getMsg());
            r.setStatus(e2.getStatus());
            return r;
        }else{
            e.printStackTrace();
            return Result.error(ResultConstants.MSG_SYSTEM_EXCEPTION);
        }
    }

    public Result addData(String name, Object value) {
        if (data == null)
            data = new HashMap<>();
        data.put(name, value);
        return this;
    }

    public Result addAllData(Map<? extends String, ?> m) {
        if (data == null)
            data = new HashMap<>();
        data.putAll(m);
        return this;
    }

    public Object getData(String name) {
        return getData().get(name);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
