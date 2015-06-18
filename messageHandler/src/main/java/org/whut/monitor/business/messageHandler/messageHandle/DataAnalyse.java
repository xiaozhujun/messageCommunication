package org.whut.monitor.business.messageHandler.messageHandle;

import org.whut.monitor.business.messageHandler.messageHandleInterface.MessageHandle;
import org.whut.monitor.business.messageHandler.utils.ByteUtil;

/**
 * Created by 涵 on 2015/5/1.
 */
public class DataAnalyse implements MessageHandle{
    @Override
    public byte[] dataToByte(String s) {
        int data = Integer.parseInt(s);
        return ByteUtil.intToBytes(data);
    }

    @Override
    public String byteToData(byte[] bytes) {
        int data = ByteUtil.bytesToInt(bytes);
        return String.valueOf(data);
    }
}
