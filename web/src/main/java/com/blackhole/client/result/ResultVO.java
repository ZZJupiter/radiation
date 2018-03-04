package com.blackhole.client.result;

import java.io.Serializable;

/**
 * Created by ZhangZhong on 2017/5/6.
 */
public class ResultVO<T> implements Serializable {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1475348231900998033L;

    private int               code;
    private boolean           success;
    private String            message;
    /** 结果 **/
    private T                 result;


    public ResultVO(boolean isSuccess, int code, String message) {
        this.success = isSuccess;
        this.code = code;
        this.message = message;
    }

    public static ResultVO success() {
        return new ResultVO(true, 200, "操作成功!");
    }

    public static ResultVO success(Object data) {
        ResultVO result = new ResultVO(true, 200, "操作成功!");
        result.setResult(data);
        return result;
    }

    public static ResultVO error(String message) {
        ResultVO result = new ResultVO(true, 500, message);
        return result;
    }

    public static ResultVO error(String message, int code) {
        ResultVO result = new ResultVO(true, code, message);
        result.setCode(code);
        return result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
