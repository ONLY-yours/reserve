package com.example.reserve.bean;

import java.util.List;

/**
 * @auther: lijunjie
 * @createDate: 2020/4/15  21:16
 * @purpose：
 */
public class CurstomListBean {
    private String success;
    private String message;
    private String code;
    private List<CurstomBean> result;
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

    public List<CurstomBean> getResult() {
        return result;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setResult(List<CurstomBean> result) {
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


    public static class CurstomBean{
//        "name": "wzw真帅",
//         "idcard": "330226200003212222",
//          "phone": "13567466366",
//          "gednder": null
        private String name;
        private String idcard;
        private String phone;
        private String gednder;

        public String getName() {
            return name;
        }

        public String getPhone() {
            return phone;
        }

        public String getGednder() {
            return gednder;
        }

        public String getIdcard() {
            return idcard;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public void setGednder(String gednder) {
            this.gednder = gednder;
        }

        public void setIdcard(String idcard) {
            this.idcard = idcard;
        }
    }





}
