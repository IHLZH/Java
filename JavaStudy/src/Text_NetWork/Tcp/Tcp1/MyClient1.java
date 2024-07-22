package Text_NetWork.Tcp.Tcp1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class MyClient1 {
    public static void main(String[] args) throws IOException {
        //1.通过IP地址和端口号连接到服务端
        //2.成功连接后，生成Socket
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        //3.得到和Socket对象关联的输出流
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream =socket.getOutputStream();
        //4.通过输出流，向数据通道中写入数据
        outputStream.write("yuanshenqidong!".getBytes());
        byte by[] = new byte[1024];
        int len = inputStream.read(by);
        System.out.println(new String(by, 0, len));
        socket.close();
        outputStream.flush();
        outputStream.close();
    }
}
