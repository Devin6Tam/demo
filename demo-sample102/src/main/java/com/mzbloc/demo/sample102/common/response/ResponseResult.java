package com.mzbloc.demo.sample102.common.response;

/**
 * Created by tanxw on 2018/12/11.
 */
public class ResponseResult<T> {

    public static final int SUCCESS = 0;
    public static final int FAILED = 0;

    private int code;
    private String msg;
    private T data;

    public ResponseResult(){
    }

    public ResponseResult(int code, String msg){
        this.code = code;
        this.msg = msg;
    }
    public ResponseResult(int code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public boolean isSuccess(){
        return this.code == SUCCESS;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
