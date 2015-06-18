package CAMCMTest;

/**
 * Created by 涵 on 2015/5/11.
 */
public class BytesGenerate {
    public static byte[] generateBytes(int len,long sensorNum,int dataType,long time,int data) {
        byte[] bytes = new byte[len];
        System.arraycopy(ByteUtil.longToBytes(sensorNum), 0, bytes, 0, 8);
        System.arraycopy(ByteUtil.intToBytes(dataType), 0, bytes, 8, 4);
        System.arraycopy(ByteUtil.longToBytes(time), 0, bytes, 12, 8);
        System.arraycopy(ByteUtil.intToBytes(data), 0, bytes, 20, 4);
        return bytes;
    }
}
