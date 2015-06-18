package CAMCMTest;

import org.whut.monitor.business.messageHandler.entity.FrameUnit;
import org.whut.monitor.business.messageHandler.utils.ByteUtil;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

/**
 * Created by 涵 on 2015/5/11.
 */
public class CAMCMServer {
    public static int PORT = 8888;
    public static void main(String[] args) {
        ServerSocket s = null;
        Socket socket = null;
        DataInputStream dis = null;
        DataOutputStream dos = null;
        byte[] bytes =null;
        byte[] bytes1 =null;
        try {
            //设定服务端的端口号
            s = new ServerSocket(PORT);
            System.out.println("ServerSocket Start:"+s);
            //等待请求,此方法会一直阻塞,直到获得请求才往下走
            socket = s.accept();
            System.out.println("Connection accept socket:"+socket);
            //用于接收客户端发来的请求
            dis= new DataInputStream(socket.getInputStream());
            dos= new DataOutputStream(socket.getOutputStream());
            while(true){
                bytes=new byte[4];
                dis.read(bytes);
                int len = ByteUtil.bytesToInt(bytes);
                System.out.println("Client Socket Message Length:"+len);
                if(len==0){
                    break;
                }
                bytes = new byte[len];
                dis.read(bytes);
                List<FrameUnit> list = BytesAnalyse.analyseBytes(bytes);
                String json =  DataStructure.structure(list);
                System.out.println("json:"+json);
                bytes1=new byte[]{1,1,1,1};
                dos.write(bytes1);
                dos.flush();
                //Thread.sleep(1000);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            System.out.println("close.....");
            try {
                dis.close();
                dos.close();
                socket.close();
                s.close();
            } catch (Exception e2) {

            }
        }
    }
    public static byte[] readBytes(InputStream in, long length) throws IOException {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int read = 0;
        while (read < length) {
            int cur = in.read(buffer, 0, (int)Math.min(1024, length - read));
            if (cur < 0) { break; }
            read += cur;
            bo.write(buffer, 0, cur);
        }
        return bo.toByteArray();
    }
}
