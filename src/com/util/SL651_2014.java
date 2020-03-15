package com.util;

import com.bean.WaterVideo;

public class SL651_2014 {

    public SL651_2014() {
    }

    public WaterVideo readString(byte[] messageBytes) {

        WaterVideo waterVideo = new WaterVideo();
        waterVideo.setCenterAddress(getCenterAddress(messageBytes));
        waterVideo.setClientAddress(getClientAddress(messageBytes));
        waterVideo.setDayRainfall(getDayRainfall(messageBytes));
        waterVideo.setYearRainfall(getYearRainfall(messageBytes));
        waterVideo.setSendTime(getSendTime(messageBytes));
        waterVideo.setMessageTime(getMessageTime(messageBytes));
        waterVideo.setVolt(getVolt(messageBytes));
        waterVideo.setWaterLevel(getWaterLevel(messageBytes));
        return waterVideo;

    }

    private String getVolt(byte[] messageBytes) {
       return Integer.toHexString(messageBytes[55]);
    }

    private String getSendTime(byte[] messageBytes) {
      return  "20" + Integer.toHexString(messageBytes[16])
                + "-" + Integer.toHexString(messageBytes[17])
                + "-" + Integer.toHexString(messageBytes[18])
                + " " + Integer.toHexString(messageBytes[19])
                + ":" + Integer.toHexString(messageBytes[20])
                + ":" + Integer.toHexString(messageBytes[21]);
    }

    private String getMessageTime(byte[] messageBytes) {
        return  Integer.toHexString(messageBytes[31])
                + "-" + Integer.toHexString(messageBytes[32])
                + "-" + Integer.toHexString(messageBytes[33])
                + " " + Integer.toHexString(messageBytes[34])
                + ":" + Integer.toHexString(messageBytes[35])
                + ":" + Integer.toHexString(messageBytes[36]);
    }

    private String getYearRainfall(byte[] messageBytes) {
        String yearRainfall = Integer.toHexString(messageBytes[50])
                + Integer.toHexString(messageBytes[51])
                + Integer.toHexString(messageBytes[52]);
        int pointIndex = messageBytes[49] & 0x07;//与操作，取末三位
        return yearRainfall.substring(0,yearRainfall.length()-1-pointIndex)
                + "."
                + yearRainfall.substring(yearRainfall.length()-1-pointIndex,yearRainfall.length()-1);
    }

    private String getWaterLevel(byte[] messageBytes) {
        String dayRainfall = Integer.toHexString(messageBytes[39])
                + Integer.toHexString(messageBytes[40])
                + Integer.toHexString(messageBytes[41])
                + Integer.toHexString(messageBytes[42]);
        int pointIndex = messageBytes[38] & 0x07;//与操作，取末三位
        return dayRainfall.substring(0,dayRainfall.length()-1-pointIndex)
                + "."
                + dayRainfall.substring(dayRainfall.length()-1-pointIndex,dayRainfall.length()-1);
    }

    private String getDayRainfall(byte[] messageBytes) {
        String dayRainfall = Integer.toHexString(messageBytes[45])
                + Integer.toHexString(messageBytes[46])
                + Integer.toHexString(messageBytes[47]);
        int pointIndex = messageBytes[44] & 0x07;//与操作，取末三位
        return dayRainfall.substring(0,dayRainfall.length()-1-pointIndex)
                + "."
                + dayRainfall.substring(dayRainfall.length()-1-pointIndex,dayRainfall.length()-1);
    }

    private String getClientAddress(byte[] messageBytes) {
        return  Integer.toHexString(messageBytes[3])
                + "-" + Integer.toHexString(messageBytes[4])
                + "-" + Integer.toHexString(messageBytes[5])
                + " " + Integer.toHexString(messageBytes[6])
                + ":" + Integer.toHexString(messageBytes[7]);
    }

    private String getCenterAddress(byte[] messageBytes) {
        return  Integer.toHexString(messageBytes[2]);
    }
}
