package org.whut.monitor.business.messageHandler.messageHandle;

import org.whut.monitor.business.messageHandler.messageHandleInterface.MessageHandle;
import org.whut.monitor.business.messageHandler.utils.ByteUtil;

/**
 * Created by 涵 on 2015/4/30.
 */
public class LengthAnalyse implements MessageHandle{

    @Override
    public byte[] dataToByte(String s){
        int length = Integer.parseInt(s);
        return ByteUtil.intToBytes(length);
    }

    @Override
    public String byteToData(byte[] bytes) {
        int length = ByteUtil.bytesToInt(bytes);
        return String.valueOf(length);
    }
}
