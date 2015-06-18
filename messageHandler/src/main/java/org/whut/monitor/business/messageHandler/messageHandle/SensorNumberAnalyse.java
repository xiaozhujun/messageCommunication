package org.whut.monitor.business.messageHandler.messageHandle;

import org.whut.monitor.business.messageHandler.messageHandleInterface.MessageHandle;
import org.whut.monitor.business.messageHandler.utils.ByteUtil;

import javax.rmi.CORBA.Util;

/**
 * Created by 涵 on 2015/5/1.
 */
public class SensorNumberAnalyse implements MessageHandle{
    @Override
    public byte[] dataToByte(String s) {
        long sensorNum=Integer.parseInt(s);
        return ByteUtil.longToBytes(sensorNum);
    }

    @Override
    public String byteToData(byte[] bytes) {
        long sensorNum = ByteUtil.bytesToLong(bytes);
        return String.valueOf(sensorNum);
    }
}
