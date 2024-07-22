package Text_NetWork.Tcp.TcpFileCopy;

import CustomFeatures.StreamUtils;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class MyClient {
    public static void main(String[] args) throws Exception {
        //Thread.sleep(10000);

        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());

        String filePath = "E:\\FileTest\\TestVideo.vip";
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(filePath));
        byte by[] = StreamUtils.streamToByteArray(bufferedInputStream);

        bufferedOutputStream.write(by);
        socket.shutdownOutput();
        bufferedOutputStream.flush();

        String strClient = bufferedReader.readLine();
        if(strClient.equals("收到图片")){
            System.out.println("客户端结束！");
        }

        bufferedOutputStream.close();
        bufferedInputStream.close();
        bufferedReader.close();
        socket.close();

    }
}
