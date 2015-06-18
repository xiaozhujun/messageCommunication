package CAMCMTest;

import org.whut.monitor.business.messageHandler.utils.ByteUtil;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * Created by 涵 on 2015/5/9.
 */
public class CAMCMClient {
    public static void main(String[] args) {
        Socket socket = null;
        DataOutputStream dos = null;
        DataInputStream dis = null;
        byte[] bytes = null;
        byte[] bytes1 = null;
        try {
            //客户端socket指定服务器的地址和端口号
            socket = new Socket("127.0.0.1", CAMCMServer.PORT);
            System.out.println("Socket=" + socket);
            //同服务器原理一样
            dos =new  DataOutputStream(socket.getOutputStream());
            dis = new DataInputStream(socket.getInputStream());
            //开始通信
            for (int i = 0; i <10000; i++) {
                //产生通信帧
                DataGenerate.generateData();
                int len = DataGenerate.len;
                long sensorNum = DataGenerate.sensorNum;
                int dataType=DataGenerate.dataType;
                long time = DataGenerate.time;
                int data = DataGenerate.data;
                System.out.println("send data:"+data);
                byte[] lengthBytes = ByteUtil.intToBytes(len);
                bytes = BytesGenerate.generateBytes(len,sensorNum,dataType,time,data);
                //发送消息长度
                dos.write(lengthBytes);
                System.out.println("bytes:"+bytes);
                dos.write(bytes);
                //接收回复消息
                bytes1=new byte[4];
                dis.read(bytes1);
                String response = String.valueOf(ByteUtil.bytesToInt(bytes1));
                System.out.println("received:"+response);
            }
            dos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                System.out.println("close......");
                dis.close();
                dos.close();
                socket.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
