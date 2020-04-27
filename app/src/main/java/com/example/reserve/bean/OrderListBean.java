package com.example.reserve.bean;

import java.util.List;

/**
 * @auther: lijunjie
 * @createDate: 2020/4/23  20:03
 * @purpose：接收用户订单列表
 */
public class OrderListBean {
    private String success;
    private String message;
    private String code;
    private List<OrderBean> result;
    private String timestamp;

    public String getCode() {
        return code;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public List<OrderBean> getResult() {
        return result;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setResult(List<OrderBean> result) {
        this.result = result;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
