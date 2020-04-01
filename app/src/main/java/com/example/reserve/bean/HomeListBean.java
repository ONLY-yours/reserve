package com.example.reserve.bean;

import java.util.List;

/**
 * @auther: lijunjie
 * @createDate: 2020/4/1  19:41
 * @purpose：
 */
public class HomeListBean {

    private String success;
    private String message;
    private String code;
    private List<homelistBean> result;
    private String timestamp;

    public String getCode() {
        return code;
    }

    public List<homelistBean> getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }

    public String getSuccess() {
        return success;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setResult(List<homelistBean> result) {
        this.result = result;
    }
    public void setSuccess(String success) {
        this.success = success;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }


    public static class homelistBean{
        // 例子:
        //      "name": "豪华套房",
        //      "price": "999.00",
        //      "imgUrl": "files/20200323/1584896348487.jpg",
        //      "roomNumber": "1"
        public String name;
        public String price;
        public String imgUrl;
        public String roomNumber;

        public String getName() {
            return name;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public String getPrice() {
            return price;
        }

        public String getRoomNumber() {
            return roomNumber;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public void setRoomNumber(String roomNumber) {
            this.roomNumber = roomNumber;
        }

    }


}

