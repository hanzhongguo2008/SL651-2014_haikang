package com.bean;

public class WaterVideo {
    //瞬时水位
    private String waterLevel;

    //当前累计雨量
    private String dayRainfall;

    public String getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(String waterLevel) {
        this.waterLevel = waterLevel;
    }

    public String getDayRainfall() {
        return dayRainfall;
    }

    public void setDayRainfall(String dayRainfall) {
        this.dayRainfall = dayRainfall;
    }

    public String getYearRainfall() {
        return yearRainfall;
    }

    public void setYearRainfall(String yearRainfall) {
        this.yearRainfall = yearRainfall;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(String messageTime) {
        this.messageTime = messageTime;
    }

    public String getVolt() {
        return Volt;
    }

    public void setVolt(String volt) {
        Volt = volt;
    }

    public String getCenterAddress() {
        return centerAddress;
    }

    public void setCenterAddress(String centerAddress) {
        this.centerAddress = centerAddress;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    //总累计雨量
    private String yearRainfall;

    //发报时间
    private String sendTime;

    //观测时间
    private String messageTime;

    //电压
    private String Volt;

    //中心站地址
    private String centerAddress;

    //遥测站地址
    private  String clientAddress;

    public WaterVideo(String waterLevel,String dayRainfall, String yearRainfall, String sendTime, String messageTime,
                   String Volt, String centerAddress, String clientAddress) {
        super();
        waterLevel = waterLevel;
        dayRainfall = dayRainfall;
        yearRainfall = yearRainfall;
        sendTime = sendTime;
        messageTime = messageTime;
        Volt = Volt;
        centerAddress = centerAddress;
        clientAddress = clientAddress;
    }

    public WaterVideo() {
    }


}
