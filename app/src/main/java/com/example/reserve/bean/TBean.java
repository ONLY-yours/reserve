package com.example.reserve.bean;

import java.util.List;

/**
 * @auther: lijunjie
 * @createDate: 2020/4/19  19:38
 * @purpose：返回值不需要信息内容的bean（通用bean）
 */
public class TBean {
    private String success;
    private String message;
    private String code;
    private String result;
    private String timestamp;

    public String getMessage() {
        return message;
    }

    public String getSuccess() {
        return success;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getCode() {
        return code;
    }

    public String getResult() {
        return result;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
