package org.whut.monitor.business.messageHandler.utils;

import java.nio.ByteBuffer;

/**
 * Created by 涵 on 2015/4/24.
 */
public class ByteUtil {
    public static byte[] intToBytes(int number){
        byte[] bytes = new byte[4];
        bytes[0]= (byte) (0xff&number);
        bytes[1]= (byte) ((0xff00&number)>>8);
        bytes[2]= (byte) ((0xff0000&number)>>16);
        bytes[3]= (byte) ((0xff000000&number)>>24);
        return bytes;
    }
    public static int bytesToInt(byte[] bytes){
        int number = bytes[0] & 0xff;
        number |= (bytes[1]<<8)&0xff00;
        number |=(bytes[2]<<16)&0xff0000;
        number |=(bytes[3]<<24)&0xff000000;
        return number;
    }
    public static byte[] combineTwoBytes(byte[] bytes1,byte[] bytes2){
        byte[] targetBytes = new byte[bytes1.length+bytes2.length];
        System.arraycopy(bytes1,0,targetBytes,0,bytes1.length);
        System.arraycopy(bytes2,0,targetBytes,bytes1.length,bytes2.length);
        return targetBytes;
    }
/*    private static ByteBuffer buffer = ByteBuffer.allocate(8);
    public static byte[] longToBytes(long x){
        buffer.putLong(0,x);
        return buffer.array();
    }
    public static long bytesToLong(byte[] bytes){
        buffer.put(bytes,0,bytes.length);
        buffer.flip();
        return buffer.getLong();
    }*/
    public static byte[] longToBytes(long number) {
        long temp = number;
        byte[] b = new byte[8];
        for (int i = 0; i < b.length; i++) {
            b[i] = new Long(temp & 0xff).byteValue();
            temp = temp >> 8;
        }
        return b;
    }
    public static long bytesToLong(byte[] b) {
        long s = 0;
        long s0 = b[0] & 0xff;// 最低位
        long s1 = b[1] & 0xff;
        long s2 = b[2] & 0xff;
        long s3 = b[3] & 0xff;
        long s4 = b[4] & 0xff;// 最低位
        long s5 = b[5] & 0xff;
        long s6 = b[6] & 0xff;
        long s7 = b[7] & 0xff; // s0不变
        s1 <<= 8;
        s2 <<= 16;
        s3 <<= 24;
        s4 <<= 8 * 4;
        s5 <<= 8 * 5;
        s6 <<= 8 * 6;
        s7 <<= 8 * 7;
        s = s0 | s1 | s2 | s3 | s4 | s5 | s6 | s7;
        return s;
    }
}
