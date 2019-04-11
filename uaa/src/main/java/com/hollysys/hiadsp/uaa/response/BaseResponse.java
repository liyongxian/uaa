/*
 * Copyright (c) EMCC 2015 All Rights Reserved
 */
package com.hollysys.hiadsp.uaa.response;

import java.io.Serializable;

/**
  * 
  * @ClassName: AbstractResponse
  * @Description: Ajax请求相应抽象类。
  * @author zhuqinghua@emcc.net.cn
  * @date 2015年7月2日 下午12:14:44
  *
 */
public class BaseResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 响应是否成功. */
    private boolean success = false;
    /** 响应的操作信息. */
    private String msg;
    /** 错误信息. */
    private String error;
    /** 错误代码    */
    private String errno;
    /** 返回的对象   */
    private Object obj;

    public BaseResponse() {}

    public BaseResponse(boolean success, String error) {
        super();
        this.success = success;
        this.error = error;
    }

    /**
     * getter method
     * @return the success
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * setter method
     * @param success the success to set
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * getter method
     * @return the error
     */
    public String getError() {
        return error;
    }

    /**
     * setter method
     * @param error the error to set
     */
    public void setError(String error) {
        this.error = error;
    }

    /**
     * setter method
     * @param msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * getter method
     */
    public String getMsg() {
        return msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public String getErrno() {
        return errno;
    }

    public void setErrno(String errno) {
        this.errno = errno;
    }
}
