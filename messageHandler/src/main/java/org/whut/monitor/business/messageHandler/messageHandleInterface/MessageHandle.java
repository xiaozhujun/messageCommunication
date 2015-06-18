package org.whut.monitor.business.messageHandler.messageHandleInterface;

/**
 * Created by 涵 on 2015/4/22.
 */
public interface MessageHandle{
    public byte[] dataToByte(String s);
    public String byteToData(byte[] bytes);
}
