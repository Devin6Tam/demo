package com.mzbloc.demo.sample108.person.vo;

/**
 * @author tanxw
 * @date 2019/6/25
 */
public class ResponseResult<T> extends BaseResult{

    private int code;
    private String msg;
    private T data;

    public ResponseResult(ResultCode resultCode) {
        this.code = resultCode.getIndex();
        this.msg = resultCode.getIndex()==0?"成功":"失败";
    }

    public ResponseResult(ResultCode resultCode, String msg) {
        this.code = resultCode.getIndex();
        this.msg = msg;
    }

    public ResponseResult(ResultCode resultCode, String msg, T data) {
        this.code = resultCode.getIndex();
        this.msg = msg;
        this.data = data;
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

    public boolean isSuccess() {
        return this.code == ResponseResult.ResultCode.SUCCESS.getIndex();
    }

    public static enum ResultCode {
        FAIL(-1),
        SUCCESS(0);

        private int index;

        private ResultCode(int index) {
            this.index = index;
        }

        public int getIndex() {
            return this.index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }
}
