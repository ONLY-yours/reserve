package com.example.reserve.bean;

import java.util.List;

/**
 * @auther: lijunjie
 * @createDate: 2020/4/23  20:07
 * @purpose：订单的item bean
 */
public class OrderBean {
    private List<OrderCurstomBean>orderCustomerList;
    private String checkinTime;
    private String checkoutTime;
    private String payMoney;
    private String roomId;
    private String floor;
    private String typeId;
    private String typeName;
    private String id;

    public String getId() {
        return id;
    }

    public String getTypeId() {
        return typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public List<OrderCurstomBean> getOrderCustomerList() {
        return orderCustomerList;
    }

    public String getCheckinTime() {
        return checkinTime;
    }

    public String getCheckoutTime() {
        return checkoutTime;
    }

    public String getFloor() {
        return floor;
    }

    public String getPayMoney() {
        return payMoney;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public void setCheckinTime(String checkinTime) {
        this.checkinTime = checkinTime;
    }

    public void setCheckoutTime(String checkoutTime) {
        this.checkoutTime = checkoutTime;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public void setOrderCustomerList(List<OrderCurstomBean> orderCustomerList) {
        this.orderCustomerList = orderCustomerList;
    }

    public void setPayMoney(String payMoney) {
        this.payMoney = payMoney;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public static class OrderCurstomBean{
        private String name;
        private String idcard;
        private String phone;
        private String gender;

        public String getGender() {
            return gender;
        }

        public String getIdcard() {
            return idcard;
        }

        public String getPhone() {
            return phone;
        }

        public String getName() {
            return name;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public void setIdcard(String idcard) {
            this.idcard = idcard;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
