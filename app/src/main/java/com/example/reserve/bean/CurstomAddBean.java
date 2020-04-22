package com.example.reserve.bean;

/**
 * @auther: lijunjie
 * @createDate: 2020/4/22  21:30
 * @purpose：
 */
public class CurstomAddBean {

    private String success;
    private String message;
    private String code;
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


    public void setMessage(String message) {
        this.message = message;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }


    public void setCode(String code) {
        this.code = code;
    }

}
