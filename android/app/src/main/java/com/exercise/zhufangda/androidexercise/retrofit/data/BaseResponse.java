//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.exercise.zhufangda.androidexercise.retrofit.data;

public class BaseResponse<T> {
    public static final int ERROR_TIMEOUT = -400;
    public static final int ERROR_PARSE_EXCEPTION = -300;
    private int errorCode;
    private String msg;
    private String encryptWay;
    private T data;

    public BaseResponse() {
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        if(data instanceof String || data == null){
            data =null;
            return;
        }

        this.data = data;
    }

    public String getEncryptWay() {
        return this.encryptWay;
    }

    public void setEncryptWay(String encryptWay) {
        this.encryptWay = encryptWay;
    }
}
