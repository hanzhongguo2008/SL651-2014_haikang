package com.entity;

import javax.persistence.*;
import java.util.Date;

public class WaterVideo {

    public void setId(Integer id) {
        this.id = id;
    }

    public void setWaterLevel(String waterLevel) {
        this.waterLevel = waterLevel;
    }

    public void setDayRainfall(String dayRainfall) {
        this.dayRainfall = dayRainfall;
    }

    public void setYearRainfall(String yearRainfall) {
        this.yearRainfall = yearRainfall;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public void setMessageTime(String messageTime) {
        this.messageTime = messageTime;
    }

    public void setVolt(String volt) {
        Volt = volt;
    }

    public void setCenterAddress(String centerAddress) {
        this.centerAddress = centerAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public void setWaterCreate(Date waterCreate) {
        this.waterCreate = waterCreate;
    }

    @Id //声明这个是数据库表的主键Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //声明主键的生成方式
    /*
     JPA提供的四种标准用法为TABLE,SEQUENCE,IDENTITY,AUTO.
     TABLE：使用一个特定的数据库表格来保存主键。
     SEQUENCE：根据底层数据库的序列来生成主键，条件是数据库支持序列。
     IDENTITY：主键由数据库自动生成（主要是自动增长型）
     AUTO：主键由程序控制(也是默认的,在指定主键时，如果不指定主键生成策略，默认为AUTO)
     */
    @Column(name = "id", unique = true, nullable = false)
    /*
    指定这个是一个数据库字段
           name 属性表示字段名称
           unique 属性表示该字段是否唯一 true : 唯一 false : 不唯一
           注意： 非主键的唯一字段会生成一个唯一索引，命名规格为 UK_随机字符串
           nullable 属性表示该字段是否可空 true ：可以为空
           length 属性表示该字段的长度
     */
    private Integer id;

    @Column(name = "waterLevel",length = 32)
    private String waterLevel;

    @Column(name = "dayRainfall",length = 32, unique = true, nullable = false)
    private String dayRainfall;

    @Column(name = "yearRainfall",length = 32)
    private String yearRainfall;

    @Column(name = "sendTime",length = 32)
    private String sendTime;

    @Column(name = "messageTime",length = 32)
    private String messageTime;

    @Column(name = "Volt",length = 32)
    private String Volt;

    @Column(name = "centerAddress",length = 32)
    private String centerAddress;

    @Column(name = "clientAddress",length = 32)
    private String clientAddress;

    public Date getWaterCreate() {
        return waterCreate;
    }

    public Integer getId() {
        return id;
    }

    public String getWaterLevel() {
        return waterLevel;
    }

    public String getDayRainfall() {
        return dayRainfall;
    }

    public String getYearRainfall() {
        return yearRainfall;
    }

    public String getSendTime() {
        return sendTime;
    }

    public String getMessageTime() {
        return messageTime;
    }

    public String getVolt() {
        return Volt;
    }

    public String getCenterAddress() {
        return centerAddress;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    @Temporal(TemporalType.TIMESTAMP)
    /*
        该注解表示这个字段是一个时间类型的
        DATE: 表示只存日期 如： 2019-07-31
        TIME: 表示只存时间 如： 19:52:25
        TIMESTAMP: 表示是一个带有时间的日期  如： 2019-07-31 19:52:25
     */
    @Column(name = "waterCreate")
    private Date waterCreate;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"waterLevel\":\"")
                .append(waterLevel).append('\"');
        sb.append(",\"dayRainfall\":\"")
                .append(dayRainfall).append('\"');
        sb.append(",\"yearRainfall\":\"")
                .append(yearRainfall).append('\"');
        sb.append(",\"sendTime\":\"")
                .append(sendTime).append('\"');
        sb.append(",\"messageTime\":\"")
                .append(messageTime).append('\"');
        sb.append(",\"Volt\":\"")
                .append(Volt).append('\"');
        sb.append(",\"centerAddress\":\"")
                .append(centerAddress).append('\"');
        sb.append(",\"clientAddress\":\"")
                .append(clientAddress).append('\"');
        sb.append("}");
        return sb.toString();
    }
}
