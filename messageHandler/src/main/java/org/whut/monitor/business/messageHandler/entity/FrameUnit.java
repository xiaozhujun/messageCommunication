package org.whut.monitor.business.messageHandler.entity;

/**
 * Created by 涵 on 2015/4/22.
 */
public class FrameUnit {
    private int byteNumber;
    private String byteToDataClasspath;
    private String byteToDataMethodName;
    private String dataToByteClasspath;
    private String dataToByteMethodName;
    private String data;
    private byte[] bytes;
    public int getByteNumber() {
        return byteNumber;
    }

    public void setByteNumber(int byteNumber) {
        this.byteNumber = byteNumber;
    }

    public String getByteToDataMethodName() {
        return byteToDataMethodName;
    }

    public void setByteToDataMethodName(String byteToDataMethodName) {
        this.byteToDataMethodName = byteToDataMethodName;
    }

    public String getByteToDataClasspath() {
        return byteToDataClasspath;
    }

    public void setByteToDataClasspath(String byteToDataClasspath) {
        this.byteToDataClasspath = byteToDataClasspath;
    }

    public String getDataToByteMethodName() {
        return dataToByteMethodName;
    }

    public void setDataToByteMethodName(String dataToByteMethodName) {
        this.dataToByteMethodName = dataToByteMethodName;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public String getDataToByteClasspath() {
        return dataToByteClasspath;
    }

    public void setDataToByteClasspath(String dataToByteClasspath) {
        this.dataToByteClasspath = dataToByteClasspath;
    }
}
