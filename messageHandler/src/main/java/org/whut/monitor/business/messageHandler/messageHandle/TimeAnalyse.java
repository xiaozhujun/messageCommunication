package org.whut.monitor.business.messageHandler.messageHandle;

import org.whut.monitor.business.messageHandler.messageHandleInterface.MessageHandle;
import org.whut.monitor.business.messageHandler.utils.ByteUtil;

/**
 * Created by 涵 on 2015/5/1.
 */
public class TimeAnalyse implements MessageHandle{
    @Override
    public byte[] dataToByte(String s) {
        long time = Long.parseLong(s);
        return ByteUtil.longToBytes(time);
    }

    @Override
    public String byteToData(byte[] bytes) {
        long time = ByteUtil.bytesToLong(bytes);
        return String.valueOf(time);
    }
}
